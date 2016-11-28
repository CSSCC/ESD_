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

        You are now logged in as Admin! 

        <div id ="nav">

            <a href="<%=request.getContextPath()%>/docs/index">Home</a><br>
            <a href="<%=request.getContextPath()%>/docs/listAllMembers">List Members</a><br>
            <a href="<%=request.getContextPath()%>/docs/listOutstandingBalances">List Outstanding Balances</a><br>
            <a href="<%=request.getContextPath()%>/docs/listClaims">List Claims</a><br>
            <a href="<%=request.getContextPath()%>/docs/listProvApps">List Prov Apps</a><br>

            <a href="<%=request.getContextPath()%>/">Logout</a>
        </div> 

        <div id ="section">
            <jsp:include page="${doco}" flush="true"/>
        </div>
    </body>
</html>
