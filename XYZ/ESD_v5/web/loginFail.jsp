<%-- 
    Document   : loginFail
    Created on : 27-Nov-2016, 11:34:05
    Author     : RickyL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Failed</title>
    </head>
    <body>
        <form action ="checkLoginDetails.jsp" method="POST">
            Username or Password is incorrect, please log in again.<br>
            Username:<input type="text" name="username"/>
            <br>
            Password:  <input type="password" name="password"/>
            </br>
            <input type="submit"/>
        </form>
    </center>
    </body>
</html>