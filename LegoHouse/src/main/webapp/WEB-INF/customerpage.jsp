<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
    Edited by Esben Dalgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int x4 = 0;
    int x2 = 0;
    int x1 = 0;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getSession().getAttribute("email")%> </h1>
        You are now logged in as a customer.
        <form name="calculateOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="calculateOrder">
            Width:<br>
            <input type="number" name="width" min="4" value="4"><br>
            Length:<br>
            <input type="number" name="length" min="4" value="4"><br>
            Height:<br>
            <input type="number" name="height" min="1" value="1"><br>
            Banding:<br>
            <input type="radio" name="band" value="1" checked> ½-stensforbandt<br>
            <input type="radio" name="band" value="2"> 1/4-stensforbandt<br>
            <input type="radio" name="band" value="3"> Blok forbandt<br>
            <input type="radio" name="band" value="4"> Kryds forbandt<br>
            <input type="radio" name="band" value="5"> Engelsk forbandt <br>
            <input type="submit" value="Calculate needed bricks">
        </form>
        <% try {
                x4 = (int) request.getSession().getAttribute("x4");
                x2 = (int) request.getSession().getAttribute("x2");
                x1 = (int) request.getSession().getAttribute("x1");
            } catch (Exception ex) {
        %>No product selected<%
            }%>
        <br>
        <%if (request.getParameter("width") != null) {
                out.println(request.getParameter("width") + "x" + request.getParameter("length") + "x" + request.getParameter("height"));
            }%>
        <h1> 4x2 bricks = <%=x4%><br>2x2 bricks = <%=x2%><br>1x2 bricks = <%=x1%></h1><br>
        <form name="placeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="placeOrder">
            <input type="submit" value="Order the calculated bricks">
        </form><br>
        <form name="getOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="getOrders">
            <input type="submit" value="My previous orders">
        </form>
    </body>
</html>
