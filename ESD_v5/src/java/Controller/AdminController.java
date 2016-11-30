/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        String requestingView = request.getParameter("viewId");
        response.setContentType("text/html;charset=UTF-8");
        
        if (requestingView.equals("/docs/checkOutBalance.jsp")) {
            updateMembership(request, Jbean, response);
        }
        else if(requestingView.equals("/docs/listClaims")){
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
