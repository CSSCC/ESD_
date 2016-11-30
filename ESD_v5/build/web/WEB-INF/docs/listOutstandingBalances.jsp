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

        <table>
            <tr>
                <th>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>

            <h1>All Outstanding Balances</h1>
            <%
                Member memb = new Member();                                 //For reading data from database    
                int balance = 0;                                            //Initialises balance      
                for (int i = 0; i < memb.getMembersSize(); i++) {
                    balance = Integer.parseInt(memb.getBalance(i));         //Converts balance from string to int
                    
                    if (balance != 0) {                                     //Checks for non-zero value of balance
                        out.println("<tr>");                                //Output given data elements for when balance is 0
                        out.println("<td>"
                                + memb.getName(i) + " </td><td>"
                                + memb.getId(i) + " </td><td> "
                                + memb.getStatus(i) + " </td><td>"
                                + memb.getBalance(i) + " </td><td>");
                    }
                }
            %>

        </table>

    </body>
</html>
