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
        <title>List Claims</title>
    </head>
    <body>
        <h1>Claim Response</h1>
        <form action ="${pageContext.request.contextPath}/AdminController" method="post">
            ID Number <input type="text" name="id"/>
            <br>
            <select>
                <option name="status" value="approved">Approved</option>
                <option name="status" value="rejected">Rejected</option>
            </select>
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
<<<<<<< HEAD
               <%
                    Claim claim = new Claim();                  //For reading data from database.
                    Member memb = new Member();                 //''
                    
                        for (int i = 0; i < claim.getClaimsSize()+1; i++) { //Loops for every data entry in database
                            out.println("<tr>");
                            out.println("<td>" 
                            + claim.getId(i) + " </td><td> "
                            + claim.getMemId(i) + " </td><td> "             //Prints all claims
                            + claim.getDate(i) + " </td><td> "
                            + claim.getRationale(i) + " </td><td> "
                            + claim.getStatus(i) + " </td><td> " 
                            + claim.getAmount(i) + " </td><td> " );
                        }
                %>
         </table>
=======
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

>>>>>>> ed050f9cd5df594c21ccdc7bbb86b0b5d266ecea
    </body>
</html>
