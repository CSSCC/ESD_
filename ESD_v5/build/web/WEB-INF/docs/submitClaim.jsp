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
        <form action ="${pageContext.request.contextPath}/ClaimController" method="post">
            <h3>Claim.</h3>         
            Date: <input type="date" name="date" />
            </br>
            Rationale:  <input type="text" name="rationale" />
            </br>
            Amount:  <input type="text" name="amount" />
            </br>
            <% String mem_id = (String) request.getAttribute("username");
            %>
            Member ID: <input type="text" name="mem_id"
            <input type="submit" />
            <input type="reset" />
                 </br>     </br>
        </form>
    </body>
</html>