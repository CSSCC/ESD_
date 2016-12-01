<%-- 
    Document   : loginFail
    Created on : 27-Nov-2016, 11:12:41
    Author     : RickyL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>XYZ Assoc</title>

        
    </head>
    <body>
        <%
        String username = (String) request.getAttribute("user");
        out.print("Welcome, " + username + "!"); 
        %>
        <br><br>
        <div id ="nav">
            <!-- Navigation Bar -->
            <a href="<%=request.getContextPath()%>/docs/index">Home</a><br>
            <a href="<%=request.getContextPath()%>/docs/checkOutBalance">Outstanding Balance & Payment</a><br>
            <a href="<%=request.getContextPath()%>/docs/submitClaim">Submit a Claim</a><br>
            <a href="<%=request.getContextPath()%>/docs/listAllClaimsMember">List All Claims and Payments to Date</a><br>

            <a href="<%=request.getContextPath()%>/">Logout</a>
        </div> 
        
        <div id ="section">
            
            
                
            <jsp:include page="${pagee}" flush="true"/>
        </div>
    </body>
</html>
