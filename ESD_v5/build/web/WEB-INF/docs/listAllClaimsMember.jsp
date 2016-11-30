<%-- 
    Document   : listAllClaimsMember
    Created on : 28-Nov-2016, 22:04:12
    Author     : t2-lings
--%>
<%@page import="Models.Member"%>
<%@page import="Models.Claim"%>
<%@page import="Models.Users"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List All Claims and Payments to Date</title>
    </head>
    <body>
        <h1>All Claims</h1>
         <table>
               <tr>
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Mem_id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Rationale&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               <%
         Claim claim = new Claim();
         Member memb = new Member();
         
       
         
           
         for (int i = 0; i < claim.getClaimsSize(); i++) {
         
         
                 out.println("<tr>");
                 out.println("<td>" 
                         + claim.getId(i) + " </td><td> "
                         + memb.getId(i) + " </td><td> "
                         + claim.getDate(i) + " </td><td> "
                         + claim.getRationale(i) + " </td><td> "
                         + claim.getStatus(i) + " </td><td> " 
                         + claim.getAmount(i) + " </td><td> " );
                         
                        
             }
         %>
    </body>
</html>
