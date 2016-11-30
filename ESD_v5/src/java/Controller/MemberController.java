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
public class MemberController extends HttpServlet {

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
        
        //if (id.equals("/docs/checkOutBalance")) {
            updatePayment(request, Jbean, response);
        //}
    }

    public void updatePayment(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {
         
        String nextJSP = "/docs/paymentError.jsp";
        Member memb = new Member();
        String username = (String) request.getSession().getAttribute("username");
        String userBalance = (String) request.getAttribute("balance");
        String balancee = "";
        int balance = 0;

        for (int i = 0; i < memb.getMembersSize(); i++) {
            username = memb.getId(i);
            if (username.equals(username)) {
                balancee = memb.getBalance(i);
                balance = Integer.parseInt(memb.getBalance(i));
            }
        }

        String amountt = request.getParameter("amount");
        int amount = Integer.parseInt(amountt);

        balance = balance - amount;

        if(balance < 0){
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
        } else {
        Jbean.executeSQLUpdate("UPDATE members SET balance = '" + balance + "' WHERE ID = '" + username + "'");
        nextJSP = "/docs/mainMember.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
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
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
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
