
<%@page import="Models.Claims"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List All Claims</title>
    </head>
    <body>
        <h1>Claims</h1> 
    <center> 
         <table>
               <tr>
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Rationale&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               <%
         Claims claim = new Claims();
         
         
           
         for (int i = 0; i < claim.getClaimsSize(); i++) {
                 out.println("<tr>");
                 out.println("<td>" + claim.getMemId(i) + " </td><td> "
                         + claim.getDate(i) + " </td><td>"
                         + claim.getRationale(i) + " </td><td>"
                            );
             }
         %>
         </table>
    </center>
    </body>
</html>

