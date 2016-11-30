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
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< HEAD
        <table>
            <tr>
                <th>Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>

            <h1>All Outstanding Balances</h1>
            <%
                Member memb = new Member();
                int balance = 0;
                for (int i = 0; i < memb.getMembersSize(); i++) {
                    balance = Integer.parseInt(memb.getBalance(i));
                    
                    if (balance != 0) {
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
=======
          <table>
               <tr>
                   <th>Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
               </tr>
               
        <h1>All Outstanding Balances</h1>
        
        
               </table>
>>>>>>> 4def6db26ffbce0a430e2060289b1d8d5f645e1e
    </body>
</html>
