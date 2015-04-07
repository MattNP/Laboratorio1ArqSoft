<%-- 
    Document   : Message
    Created on : 6/04/2015, 03:39:32 PM
    Author     : esteban.catanoe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1><%=request.getAttribute("Message")%> </h1>
        </center>
    </body>
</html>
