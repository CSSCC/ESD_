<%-- 
    Document   : listAllMembers
    Created on : 28-Nov-2016, 19:24:54
    Author     : ra7-lewis
--%>

<%@page import="Models.Member"%>
<%@page import="Models.Claim"%>
<%@page import="Models.Users"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Claim Response</h1>
        <form action ="${pageContext.request.contextPath}/AdminController" method="post">
            ID Number <input type="text" name="id"/>
            <br>
            APPROVED/REJECTED <input type="text" name="status"/>
            <br>
            <input type="submit"/>
        </form>

        <h1>All Claims</h1>
        <table>
            <tr>
                <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Rationale&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>
            <%
                Claim claim = new Claim();
               
                for (int i = 0; i < claim.getClaimsSize() + 1; i++) {

                    out.println("<tr>");
                    out.println("<td>"
                            + claim.getId(i) + " </td><td> "
                            + claim.getMemId(i) + " </td><td> "
                            + claim.getDate(i) + " </td><td> "
                            + claim.getRationale(i) + " </td><td> "
                            + claim.getStatus(i) + " </td><td> "
                            + claim.getAmount(i) + " </td><td> ");
                }
            %>
        </table>

        <br>

    </body>
</html>
