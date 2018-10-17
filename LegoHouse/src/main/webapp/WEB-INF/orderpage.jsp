<%-- 
    Document   : orderpage
    Created on : 17-10-2018, 20:04:04
    Author     : Esben
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%try {
                ArrayList<String> a = (ArrayList) request.getSession().getAttribute("orderList");
                for (int i = 0; i < a.size(); i++) {
                    out.print(a.get(i));
                }
            } catch (Exception ex) {
            }
        finally{}%>
    </body>
</html>
