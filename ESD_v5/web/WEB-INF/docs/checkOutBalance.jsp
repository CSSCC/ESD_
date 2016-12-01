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
        <table>
            <tr>
                <th>ID</th>
                <th>Current Balance</th>

                
                
                        <!--Lists balance based on the user-->
                <%
                    Member memb = new Member();
                    int balance = 0;
                    String username = (String) request.getAttribute("user"); // gets current user from servlet
                    String user = "";

                    for (int i = 0; i < memb.getMembersSize(); i++) { // loops through members
                        balance = Integer.parseInt(memb.getBalance(i)); // converts balance string to int
                        user = memb.getId(i); 

                        if (user.equals(username)) { //if user name in database matches current user
                            out.println("<tr>");
                            out.println("<td>"
                                    + memb.getId(i) + " </td><td>" //print username
                                    + memb.getBalance(i) + " DR </td><td>"); // print balance
                            request.setAttribute("balance", memb.getBalance(i));
                        }
                    }
                %>               
        </table>
        <h1>Make a Payment</h1>
        <form action ="${pageContext.request.contextPath}/MemberController" method="post">
            Payment Amount<input type="text" name="amount"/>
            <br>
            <input type="submit"/>


        </form>
    </body>
</html>