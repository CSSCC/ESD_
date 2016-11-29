
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
    <center> 
         <table>
               <tr>
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               <%
         Member memb = new Member();
         
         
           
         for (int i = 0; i < memb.getMembersSize(); i++) {
                 out.println("<tr>");
                 out.println("<td>" + memb.getId(i) + " </td><td> "
                         + memb.getName(i) + " </td><td>"
                         + memb.getAddress(i) + " </td><td>"
                            );
             }
         %>
         </table>
    </center>
    </body>
</html>