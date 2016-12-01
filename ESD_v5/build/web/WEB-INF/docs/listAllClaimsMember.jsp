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
                <th> ID </th>
                <th> Mem_id </th>
                <th> Date </th>
                <th> Rationale </th>
                <th> Status </th>
                <th> Amount </th>
            </tr>
            <%
                Claim claim = new Claim();
                String user = (String) request.getAttribute("user");

                for (int i = 0; i < claim.getClaimsSize(); i++) {

                    if (user.equals(claim.getMemId(i))) {
                        out.println("<tr>");
                        out.println("<td>"
                                + claim.getId(i) + "</td><td>"
                                + claim.getMemId(i) + "</td><td>"
                                + claim.getDate(i) + "</td><td>"
                                + claim.getRationale(i) + "</td><td>"
                                + claim.getStatus(i) + "</td><td>"
                                + claim.getAmount(i) + "</td><td>");
                    }

                }


            %>
        </table>
        <h1> All Payments </h1>
        <table>
            <tr>
                <th> ID </th>
                <th> Mem_id </th>
                <th> Payment </th>
                <th> Amount </th>
                <th> Date </th>
            </tr>
            <%                Payment pay = new Payment();
                for (int i = 0; i < pay.getPaymentSize(); i++) {
                    if (user.equals(pay.getMemId(i))) {
                        out.println("<tr>");
                        out.println("<td>"
                                + pay.getId(i) + "</td><td>"
                                + pay.getMemId(i) + "</td><td>"
                                + pay.getTypeOfPayment(i) + "</td><td>"
                                + pay.getAmount(i) + "</td><td>"
                                + "2016-12-05 14:32:13" + "</td><td>");
                    }
                }
            %>

        </table>


    </body>
</html>