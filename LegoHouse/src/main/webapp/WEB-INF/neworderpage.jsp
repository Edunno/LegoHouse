<%-- 
    Document   : neworderpage
    Created on : 17-10-2018, 13:32:51
    Author     : Esben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New order </title>
    </head>
    <body>
        <h1>Order receipt:</h1><br>
        Length: <%=request.getSession().getAttribute("length")%><br>
        Width: <%=request.getSession().getAttribute("width")%><br>
        Height: <%=request.getSession().getAttribute("height")%><br>
        Band:
        Total amount of bricks: <%
            int x4 = (int) request.getSession().getAttribute("x4");
            int x2 = (int) request.getSession().getAttribute("x2");
            int x1 = (int) request.getSession().getAttribute("x1");
            out.println(x1 + x2 + x4);%><br>
        Order Id: <%=request.getSession().getAttribute("lastorder")%>
        <% request.getSession().removeAttribute("length");
            request.getSession().removeAttribute("width");
            request.getSession().removeAttribute("height");
            request.getSession().removeAttribute("x1");
            request.getSession().removeAttribute("x2");
            request.getSession().removeAttribute("x4");
            request.getSession().removeAttribute("lastorder");%>
            <form name="returnToCP" action="FrontController" method="POST">
                <input type="hidden" name="command" value="returnToCP">
                <input type="submit" value="Return to Customer Page"
    </body>
</html>
