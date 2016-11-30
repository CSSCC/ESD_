<%-- 
    Document   : calculateAnnualCharge
    Created on : 30-Nov-2016, 19:02:39
    Author     : jm2-dadd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calculate Annual Charge</h1>
    </body>
    
            <form action ="${pageContext.request.contextPath}/AdminController" method="post">
               
                Enter Year <input type="text" name="year"/>
           
                <br>
               </select>
            <br>
            <input type="submit"/>
            </form>
</html>