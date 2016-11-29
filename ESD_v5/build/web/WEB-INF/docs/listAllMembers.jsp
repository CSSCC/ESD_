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
        <title>List All Members</title>
    </head>
    <body>
        <h1>Members</h1> 
         <table>
               <tr>
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Dob&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Dor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               <%
         Member memb = new Member();
         int balance = 0;
           
         for (int i = 0; i < memb.getMembersSize(); i++) {
             balance = Integer.parseInt(memb.getBalance(i));
             if(balance != 0){
                 out.println("<tr>");
                 out.println("<td>" 
                         + memb.getId(i) + " </td><td> "
                         + memb.getName(i) + " </td><td>"
                         + memb.getAddress(i) + " </td><td>"
                         + memb.getDob(i) + " </td><td>"
                         + memb.getDor(i) + " </td><td>"
                         + memb.getStatus(i) + " </td><td>"
                         + memb.getBalance(i) + " </td><td>");
             }
         }
         %>
         </table>
    </body>
</html>