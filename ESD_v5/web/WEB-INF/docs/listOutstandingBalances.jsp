
<%@page import="Models.Member"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Members</title>
    </head>
    <body>
        <h1>Outstanding Balances</h1> 
    <center> 
         <table>
               <tr>
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>OutstandingBalance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               <%
         Member memb = new Member();

         int balance = 0;
         
         for (int i = 0; i < memb.getMembersSize(); i++) {
                 balance = Integer.parseInt(memb.getBalance(i));
                 out.println("<tr>");
                 out.println("<td>" + memb.getId(i) + " </td><td> "
                         + memb.getName(i) + " </td><td>"
                         + (i) + " </td><td>");
             }
         %>
         </table>
    </center>
    </body>
</html>