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
        <title>List All Members</title>
    </head>
    <body>
        <h1>Members</h1> 
         
        <%=(String)(request.getAttribute("query"))%>
    </body>
</html>