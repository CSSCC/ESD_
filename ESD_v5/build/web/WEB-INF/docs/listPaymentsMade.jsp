<%-- 
    Document   : loginreg
    Created on : 27-Nov-2016, 20:09:31
    Author     : ra7-lewis
--%>

<%@page import="Models.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Payments Made</title>
    </head>
    <h1> All Payments </h1>
    <table>
        <tr>
            <th> ID </th>
            <th> Mem_id </th>
            <th> Payment </th>
            <th> Amount </th>
            <th> Date </th>
        </tr>
        <%               
            Payment pay = new Payment(); // calls payment model
            for (int i = 0; i < pay.getPaymentSize(); i++) { // iterates through payment table

                out.println("<tr>");
                out.println("<td>"
                        + pay.getId(i) + "</td><td>" //prints data
                        + pay.getMemId(i) + "</td><td>"
                        + pay.getTypeOfPayment(i) + "</td><td>"
                        + pay.getAmount(i) + "</td><td>"
                        );
            }
        %>

    </table>
</html>
