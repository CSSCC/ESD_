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
                   <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <th>Current Balance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                   <%
                        //PRINTS USERS INFORMATION*****************
                        Member memb = new Member();                                         //For retrieving variables through model to database.
                        int balance = 0;                                                    //Initialises balance at 0
                        String username = (String) request.getAttribute("user");            //Gets username currently logged in
                        String user = "";

                        for (int i = 0; i < memb.getMembersSize(); i++) {                   //loops for every row
                            balance = Integer.parseInt(memb.getBalance(i));
                            user = memb.getId(i);

                            if (user.equals(username)) {                                    //Checks if username matches
                                out.println("<tr>");
                                out.println("<td>"
                                        + memb.getId(i) + " </td><td>"                      //Prints info
                                        + memb.getBalance(i) + " DR </td><td>");
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
