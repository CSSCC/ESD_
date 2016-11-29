<%-- 
    Document   : loginreg
    Created on : 27-Nov-2016, 20:09:31
    Author     : ra7-lewis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <form action ="checkLoginDetails.jsp" method="post">
            <h3>Welcome, please log in.</h3>
            Username:<input type="text" name="username"/>
            <br>
            Password:  <input type="password" name="password"/>
            </br>
            <input type="submit" value="Log in"/>
                 </br>     </br>
        </form>
        
        <form action ="checkRegisterDetails.jsp" method="post">
            <h3>Please Register.</h3>
            Username:<input type="text" name="username"/>
            <br>
            Name  <input type="text" name="name"/>
            </br>
            Password:  <input type="password" name="password"/>
            </br>
            Address:  <input type="text" name="address"/>
            </br>
            DOB  <input type="date" name="dob"/>
            
            </br>
            <input type="submit" value="Register"/>
                 </br>     </br>
        </form>
</html>
