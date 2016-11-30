/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jm2-dadd
 */

package Controller;
 
import Models.Claim;
 import java.io.IOException;
 import java.sql.SQLException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import Models.Jdbc;
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 /**
  *
  * @author JDadd
  */

public class ClaimsController extends HttpServlet {
 
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
         Claim claim = new Claim();
         
         String mem_id = (String) request.getSession().getAttribute("username");
         String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());;
         String rationale = request.getParameter("rationale");
         String status = "SUBMITTED";
         String amount = request.getParameter("amount");
 
         int id = 0;
         int claimsId = 0;
         String claimsIdString = "";
         
         //get max id in claims
         for (int i = 0; i < claim.getClaimsSize(); i++) {
             claimsIdString = claim.getId(i);
             claimsId = Integer.parseInt(claimsIdString);
             if(id < claimsId){
                id = claimsId;
            }
        }
         claimsId++;
         
 
         Jbean.executeSQLUpdate("INSERT INTO claims (id, mem_id, date, rationale, status, amount) VALUES ('" + claimsId + "', '" + mem_id + "', '" + date + "', '" + rationale + "', '" + status + "', '" + amount + "')");
 
         String nextJSP = "/docs/mainMember.jsp";
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
         dispatcher.forward(request,response);
         
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
             Logger.getLogger(ClaimsController.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(ClaimsController.class.getName()).log(Level.SEVERE, null, ex);
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
    