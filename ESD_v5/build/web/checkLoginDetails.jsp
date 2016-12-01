<%-- 
    Document   : checkLoginDetails
    Created on : 27-Nov-2016, 11:28:01
    Author     : RickyL
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Login"%>
<%
        Login log = new Login();
        
        String username = request.getParameter("username");  // retrieves username parameter
        String password = request.getParameter("password"); // retrieves password parameter
        session.setAttribute("username", username); // sets SESSION username attribute
        
        if(log.getUsername().contains(username) && log.getPassword().contains(password)) { // if log in details are correct
            response.sendRedirect(request.getContextPath() + "/docs/index"); // login
        } else {
            response.sendRedirect("loginFail.jsp"); // fail
        }
        
%>  
