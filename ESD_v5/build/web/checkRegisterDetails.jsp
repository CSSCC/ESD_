<%-- 
    Document   : checkLoginDetails
    Created on : 27-Nov-2016, 11:28:01
    Author     : RickyL
--%>

<%@page import="Models.Member"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Login"%>
<%
        Member memb = new Member();
            
            String username = request.getParameter("username");
            String name = request.getParameter("username");
            String address = request.getParameter("address");
            String dob = request.getParameter("dob");
            
            int size = memb.getMembersSize();
            int count = 0;
            
            
            for (int i = 0; i < size; i++) {
                    if (name.equals(memb.getName(i))) {
                        %>
                        <h1>Error <%=name%> already in database!</h1><%
                        break;
                    } else {
                        count++;
                    }
                }
            if (count == size) {
                        %>
                <h1><%=name%> added to the database</h1><%
                                memb.addMember(id, registration, password);
                            }
                        %>
            <form action="<%=request.getContextPath()%>/docs/editDriver" method="post">
                <button type="submit">Go back</button>
            </form>
%>  
