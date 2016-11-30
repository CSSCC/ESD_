<%-- 
    Document   : index
    Created on : 28-Nov-2016, 19:14:57
    Author     : ra7-lewis
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        
        
        <h1>XYZ Assoc</h1>

        <form action ="checkLoginDetails.jsp" method="post">
            <h3>Welcome, please log in.</h3>
            Username:<input type="text" name="username"/>
            <br>
            Password:  <input type="password" name="password"/>
            </br>
            <input type="submit"/>
            
            
        </form>
        <br>
        
         <form action ="${pageContext.request.contextPath}/RegistrationController" method="post">
            <h3>Register.</h3>
            Name  <input type="text" name="name" />
            </br>
            Address:  <input type="text" name="address" />
            </br>
            DOB  <input type="date" name="dob" />
            </br>
 
            <input type="submit" />
            <input type="reset" />
                 </br>     </br>
        </form>
</body>
</html>