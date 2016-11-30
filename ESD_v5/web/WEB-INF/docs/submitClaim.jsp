<%-- 
    Document   : submitClaim
    Created on : 28-Nov-2016, 22:00:09
    Author     : t2-lings
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit a Claim</title>
    </head>
    <body>
        <h1>Submit a Claim</h1>
        <form action ="${pageContext.request.contextPath}/ClaimsController" method="post">

            Rationale:  <input type="text" name="rationale" style="height:100px;width:300px;font-size:14pt;" />
            </br>
            Amount:     <input type="text" name="amount" />
            </br>
            <input type="submit" />
            <input type="reset" />
                 </br>     </br>
        </form>
    </body>
</html>