<%-- 
    Document   : checkOutBalance
    Created on : 28-Nov-2016, 21:48:23
    Author     : t2-lings
--%>

<%@page import="Models.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outstanding Balance</title>
    </head>
    <body>
        <h1>Check Outstanding Balance</h1>
        <%
                Member memb = new Member();
                int balance = 0;
                String username = (String) request.getAttribute("user");
                String user = ""; 
                
                out.print(username);
                for (int i = 0; i < memb.getMembersSize(); i++) {
                    balance = Integer.parseInt(memb.getBalance(i));
                    user = memb.getId(i);
                    
                   
                    if(user.equals(username)){
                        out.println("<tr>");
                        out.println("<td>"
                    
                                + memb.getId(i) + " </td><td>" 
                                + memb.getBalance(i) + " </td><td>");
                   }
                
                }
            %>
    </body>
</html>
