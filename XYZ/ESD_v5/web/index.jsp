<%-- 
    Document   : index
    Created on : 27-Nov-2016, 19:44:08
    Author     : ra7-lewis
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>

       <div id="header">
            <jsp:include page="templates/header.jsp" flush="true" /> <%-- displays header --%> 
        </div>
        <div id="menu">
            <jsp:include page="templates/menu.jsp" flush="true" /> <%-- displays menu --%> 
        </div>
        
        </br>
        <div id="body">
            <%--IF LOGGED IN CHECK --%>
                <% String pageName = (String) request.getAttribute("page"); //get pagename from servlet
                
                    if (pageName == null) { //if not inisiated
                       // out.println("Found = " + pageName); 
                        pageName = "WEB-INF/docs/loginreg.jsp"; //display login
                    }
                    //out.print("Page Name = " + pageName); 
                %>
                <jsp:include page="<%=pageName%>" flush="true" /> <%-- if !null go to page requested --%> 
            </div>       
    
</body>
</html>