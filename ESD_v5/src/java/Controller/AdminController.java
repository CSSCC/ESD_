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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        Jdbc Jbean = new Jdbc(); // calls Database
        String id = request.getRequestURI().substring(request.getContextPath().length());
        response.setContentType("text/html;charset=UTF-8");
        String pathTrace = request.getHeader("referer"); // gets previous page url

        if (pathTrace.equals("http://localhost:8084/ESD_v5/docs/listProvApps")) { // if page matches run method
            updateMembership(request, Jbean, response);
        } else if (pathTrace.equals("http://localhost:8084/ESD_v5/docs/listClaims")) {
            updateClaimStatus(request, Jbean, response);
        } else if (pathTrace.equals("http://localhost:8084/ESD_v5/docs/calculateAnnualCharge")) {
            calcAnnualFee(request, Jbean, response);
        } else if (pathTrace.equals("http://localhost:8084/ESD_v5/docs/chargeSubFee")) {
            chargeAnnualSubscriptionFee(request, Jbean, response);
        }
    }

    public void updateMembership(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String mem_id = request.getParameter("mem_id"); // retrieves parameter usernamee
        String status = request.getParameter("status");
   
        Jbean.executeSQLUpdate("UPDATE members SET status = '"+status+ "' WHERE ID = '" + mem_id + "'"); // executes statement via database and make changes

        String direct = "http://localhost:8084/ESD_v5/docs/changesMade"; // redirect 
        response.sendRedirect(direct);
    }

    public void updateClaimStatus(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String id = request.getParameter("id"); // gets id parameter
        String status = request.getParameter("status"); // get status parameter

        Jbean.executeSQLUpdate("UPDATE claims SET status = '" + status + "' WHERE ID = '" + id + "'"); // executes statement via database and make changes

        String direct = "http://localhost:8084/ESD_v5/docs/changesMade"; // redirect
        response.sendRedirect(direct);
    }

    public void calcAnnualFee(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws SQLException, IOException, ServletException {

        ArrayList<String> memberIDs;
        int memberTotal;
        ArrayList<String> claimIDs;
        int claimTotal;
        int amountTotal = 0;
        memberIDs = Jdbc.runQuery("SELECT * FROM members", "id"); // executes statement via database and gets data
        memberTotal = memberIDs.size();
        claimIDs = Jdbc.runQuery("SELECT * FROM claims", "id"); // executes statement via database and gets data
        claimTotal = claimIDs.size();
        Claim claim = new Claim();
        Member memb = new Member();
        String yearCheck = "";
        String[] temp = new String[3];
        String balancee = "";
        int balance = 0;
        String year = request.getParameter("year");

        // Adds the claim totals
        for (int i = 0; i < claimTotal; i++) { // iterates through claims
            temp = claim.getDate(i).split("-"); //split date into segements
            if ("APPROVED".equals(claim.getStatus(i))) { // if claim approved
                if (temp[0].equals(year)) { // and date is within this year
                    amountTotal = amountTotal + Integer.parseInt(claim.getAmount(i)); // add claim amount to total
                }
            }
        }

        int charge = amountTotal / memberTotal; // divide total between members
        //OUTPUT
        for (int i = 0; i < memb.getMembersSize(); i++) { // iterate members
            // if ("APPROVED".equals(memb.getStatus(i))) {
            balance = 0;
            balancee = memb.getBalance(i);
            balance = Integer.parseInt(balancee);
            balance = balance + charge;
            Jbean.executeSQLUpdate("UPDATE members SET balance = '" + balance + "' WHERE ID = '" + memb.getId(i) + "'");   // executes statement via database and make changes
            //  }
        }

        String direct = "http://localhost:8084/ESD_v5/docs/changesMade"; // redirect
        response.sendRedirect(direct);

    }

    public void chargeAnnualSubscriptionFee(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws SQLException, IOException, ServletException {

        Member memb = new Member();
        String[] temp1 = new String[3];
        String[] temp2 = new String[3];
        String dor = "";
        String todaysDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); // gets todays date

        for (int i = 0; i < memb.getMembersSize(); i++) { // iterates through members
            dor = memb.getDor(i);
            temp1 = dor.split("-"); // splits date
            temp2 = todaysDate.split("-");

            if (temp1[2].equals(temp2[2])) { // if day of month matches todays day
                if (temp1[1].equals(temp2[1])) { // if month matches current month 

                    String balancee = memb.getBalance(i);
                    int balance = Integer.parseInt(balancee);
                    balance = balance + 5; // add charge to balance
                    Jbean.executeSQLUpdate("UPDATE members SET balance = '" + balance + "' WHERE ID = '" + memb.getId(i) + "'");   // executes statement via database and make changes
                }
            }
        }
        String direct = "http://localhost:8084/ESD_v5/docs/changesMade"; // redirect
        response.sendRedirect(direct);
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
            Logger.getLogger(AdminController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
