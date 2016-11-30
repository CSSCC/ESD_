/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Claim;
import Models.Jdbc;
import Models.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ra7-lewis
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        Jdbc Jbean = new Jdbc();
        String id = request.getRequestURI().substring(request.getContextPath().length());
        response.setContentType("text/html;charset=UTF-8");
        String pathTrace = request.getHeader("referer");
        
        if (pathTrace.equals("http://localhost:8084/ESD_v5/docs/listProvApps")) {     
            updateMembership(request, Jbean, response);
        }
        else if(pathTrace.equals("http://localhost:8084/ESD_v5/docs/listClaims")){
            updateClaimStatus(request, Jbean, response);
       }
    }

    public void updateMembership(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {
         
        String nextJSP = "/docs/listProvApps.jsp";
        String mem_id = request.getParameter("mem_id");
       
        Jbean.executeSQLUpdate("UPDATE members SET status = 'APPROVED' WHERE ID = '" + mem_id + "'");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
        }
        
    public void updateClaimStatus(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {
         
        String nextJSP = "/docs/listClaims.jsp";
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        
        Jbean.executeSQLUpdate("UPDATE claims SET status = '"+ status +"' WHERE ID = '" + id + "'");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
        }
        
    ArrayList<String> memberIDs;
    int memberTotal;
    ArrayList<String> claimIDs;
    int claimTotal;        
    int amountTotal = 0;        
    
    public void calcAnnualFee (HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
        memberIDs = Jdbc.runQuery("SELECT * FROM members", "id");
        memberTotal = memberIDs.size();
        claimIDs = Jdbc.runQuery("SELECT * FROM claims", "id");
        claimTotal = claimIDs.size();
        Claim claim = new Claim();
        Member memb = new Member();
        String yearCheck = "";
        String[] temp = new String[3];
        String balancee = "";
        int balance = 0;
        Jdbc Jbean = new Jdbc();
        String year = request.getParameter("year");
        
        for (int i=0; i<claimTotal; i++) {
            temp = claim.getDate(i).split("-") ;
            
            if(temp[0] == year){
                amountTotal = amountTotal + Integer.parseInt(claim.getAmount(i));
            }
        }           
        
        int charge = amountTotal / memberTotal; 
      
        for (int i = 0; i < memberTotal; i++) {
                balance = 0;
                balancee = memb.getBalance(i);
                balance = Integer.parseInt(memb.getBalance(i));
                balance = balance + charge;
                Jbean.executeSQLUpdate("UPDATE members SET balance = '"+ balance +"' WHERE ID = '" + memb.getId(i) + "'");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
