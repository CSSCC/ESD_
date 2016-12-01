/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

/**
 *
 * @author Loy
 */
public class RegistrationController extends HttpServlet {

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
            throws ServletException, IOException {
        
        Jdbc Jbean = new Jdbc();
        
        String username;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = "";
        String dob = request.getParameter("dob");
        String dor = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String status = "APPLIED";
        String balance = "10";

        //****************MAKING USERNAME*******************
        //Initialising
        char firstChar;
        username = "";
        String[] str1 = new String[2];
        
        //Getting first char of first name
        firstChar = name.charAt(0);
        username = username + firstChar;
        
        //Splitting Name to retrieve surname
        str1 = name.split(" ");
        username = username + "-" + str1[(str1.length) - 1];
        
        //Changing username to lower case
        username = username.toLowerCase();
        
        //******************MAKING PASSWORD*********************
        
        //Initialising
        String[] str2 = new String[3];
        
        //Splitting into temporary String array
        str2 = dob.split("-");
        
        //Discarding the first to digits of year of birth
        String temp = "";                   
        temp = temp + str2[0].charAt(2) + str2[0].charAt(3);
        str2[0] = temp;
        
        //building password from temp array
        for(int i=(str2.length - 1);i>=0;i--){     
            password = password + str2[i];
        }
        

        Jbean.executeSQLUpdate("INSERT INTO members (id, name, address, dob, dor, status, balance) VALUES ('" + username + "', '" + name + "', '" + address + "', '" + dob + "', '" + dor + "', '" + status + "', '" + balance + "')");

        Jbean.executeSQLUpdate("INSERT INTO users (id, password, status) VALUES ('" + username + "', '" + password + "', '" + status + "')");

        request.setAttribute("user", username);
        request.setAttribute("password", password);
        String nextJSP = "/index.jsp";
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
        processRequest(request, response);
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
        processRequest(request, response);
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
