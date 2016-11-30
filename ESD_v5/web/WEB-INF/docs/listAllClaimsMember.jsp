<%@page import="Models.Payment"%>
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
                //LISTS ALL CLAIMS MADE BY CURRENTLY LOGGED IN MEMBER******************
                Claim claim = new Claim();                                      //Sets up instance of Claim for reading database
                String user = (String) request.getAttribute("user");            //Gets String for the currently logged in user.
                for (int i = 0; i < claim.getClaimsSize(); i++) {
                    if (user.equals(claim.getMemId(i))) {                       //Checks for username match and only outputs when it does
                        out.println("<tr>");
                        out.println("<td>"
                                + claim.getId(i) + "</td><td>"
                                + claim.getMemId(i) + "</td><td>"               //Outputs information in correct format.
                                + claim.getDate(i) + "</td><td>"
                                + claim.getRationale(i) + "</td><td>"
                                + claim.getStatus(i) + "</td><td>"
                                + claim.getAmount(i) + "</td><td></tr>");
                    }
                }
            %>
        </table>

        <h1> All Payments </h1>
        <table>
            <tr>
                <th>ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Mem_id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Payment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th>Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>
            <%                   
                Payment pay = new Payment();
                String user2 = (String) request.getAttribute("user");
                for (int i = 0; i < pay.getPaymentSize(); i++) {
                    if (user2.equals(pay.getMemId(i))) {
                        out.println("<tr>");
                        out.println("<td>"
                                + pay.getId(i) + "</td><td>"
                                + pay.getMemId(i) + "</td><td>"
                                + pay.getTypeOfPayment(i) + "</td><td>"
                                + pay.getAmount(i) + "</td><td>"
                                + pay.getDate(i) + "</td><td></tr>");
                    }
                }
            %>

        </table>
    </body>
</html>