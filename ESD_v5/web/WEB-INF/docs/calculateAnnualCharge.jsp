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
                Which year <select> <option name="year" value="2016">2016 </option>
                <option name="year" value="2015">2015 </option>
                <option name="year" value="2014">2014 </option>
                <option name="year" value="2013">2013 </option>
                <option name="year" value="2012">2012 </option>
                <option name="year" value="2011">2011 </option>
               </select>
            <br>
            <input type="submit"/>
            </form>
</html>