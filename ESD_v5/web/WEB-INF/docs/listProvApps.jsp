<%-- 
    Document   : listAllMembers
    Created on : 28-Nov-2016, 19:24:54
    Author     : ra7-lewis
--%>

<%@page import="Models.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Provisional Applications</title>
    </head>
    <body>
        <h1>Provisional Members</h1> 
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Status</th>
                <th>Balance</th>
            </tr>
            <%
                Member memb = new Member();                             //Used for reading from database
                int balance = 0;                                    
                String status = "";
                for (int i = 0; i < memb.getMembersSize(); i++) {       //Loops for every database entry
                    balance = Integer.parseInt(memb.getBalance(i));     
                    status = memb.getStatus(i);                         //Gets value for status 
                    if ("APPLIED".equals(status)) {                     //Checks if status is applied and outputs list if it is.
                        out.println("<tr>");
                        out.println("<td>"
                                + memb.getId(i) + " </td><td> "
                                + memb.getName(i) + " </td><td>"
                                + memb.getStatus(i) + " </td><td>"
                                + memb.getBalance(i) + " </td><td>");
                    }
                }
            %>
        </table>
        <br>
        <br>
        <h1>Edit Membership</h1>
            <form action ="${pageContext.request.contextPath}/AdminController" method="post">
                Member Id  <input type="text" name="mem_id"/><br>
                APPLIED/APPROVED/SUSPENDED  <input type="text" name="status"/>
            <br>
            <input type="submit"/>
            </form>
    </body>
</html>
