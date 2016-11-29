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
        
        String username = request.getParameter("username"); 
        String password = request.getParameter("password");
        session.setAttribute("username", username);
        
        if(log.getUsername().contains(username) && log.getPassword().contains(password)) {
            response.sendRedirect(request.getContextPath() + "/docs/index");
        } else {
            response.sendRedirect("loginFail.jsp");
        }
        
%>  
