package Controller;

import Models.Jdbc;
import Models.Member;
import Models.Pages;
import Models.Payment;
import Models.Users;
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

        Jdbc Jbean = new Jdbc(); // calls the database handler
        response.setContentType("text/html;charset=UTF-8");

        //if (id.equals("/docs/checkOutBalance")) {
        updatePayment(request, Jbean, response); // runs update payment
        //}
    }

    public void updatePayment(HttpServletRequest request, Jdbc Jbean, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Member memb = new Member(); //calls member modelS
        String username = (String) request.getSession().getAttribute("username"); // calls the username from the session
        String balancee = "";
        int balance = 0;

        for (int i = 0; i < memb.getMembersSize(); i++) { //iterates through members database
            String user = memb.getId(i);
            if (username.equals(user)) { //if username matches current year
                balancee = memb.getBalance(i); //gets the users balance
                balance = Integer.parseInt(memb.getBalance(i)); // converts it to int
            }
        }

        String amountt = request.getParameter("amount"); //requests parameter amount from jsp form
        int amount = Integer.parseInt(amountt); // converts it to int

        balance = balance - amount; // subtract amount paid from balance

        if (balance < 0) { // makes sure the balance will not drop below 0

            String direct = "http://localhost:8084/ESD_v5/docs/paymentError";
            response.sendRedirect(direct);
        } else {
            Jbean.executeSQLUpdate("UPDATE members SET balance = '" + balance + "' WHERE ID = '" + username + "'"); // updates sql database with results

            Payment pay = new Payment(); // opens payment model
            int id = 0;
            int payId = 0;
            String payIdString = "";

            //get max id in claims
            for (int i = 0; i < pay.getPaymentSize(); i++) { // iterates through payments
                payIdString = pay.getId(i); 
                payId = Integer.parseInt(payIdString);
                if (id < payId) { // finds biggest payment id
                    id = payId; // sets biggest payemet id
                }
            }
            payId++;

            Jbean.executeSQLUpdate("INSERT INTO payments (id, mem_id, type_of_payment, amount, date) VALUES ('" + payId + "', '" + username + "', 'FEE', '" + amount + "', '2016-01-05 15:13:43')"); // updates sql database with results

            String direct = "http://localhost:8084/ESD_v5/docs/paymentSuccessful"; // redirect
            response.sendRedirect(direct);
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
            Logger.getLogger(MemberController.class
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
            Logger.getLogger(MemberController.class
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
