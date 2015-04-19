<%-- 
    Document   : Consulta
    Created on : 17/04/2015, 05:21:09 PM
    Author     : jorgel.diaz <jlditru@gmail.com>
--%>

<%@page import="com.udea.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>CONSULTA</title>
    </head>
    <body>
    <center>
        <div class="container well">
            <h1>CONSULTA</h1>
            <form method="post" action="ConsultarServlet" enctype="multipart/form-data">
                <table border="0">                         
                    
                    <tr>
                        <td>Nombres: </td>
                        <td><input type="text" name="firstName" class="form-control" placeholder="${lista[status.index+0]}"size="50" disabled="disabled"/></td>
                    </tr>

                    <tr>
                        <td><br>Apellidos: </td>

                        <td>
                            <br><input type="text" name="lastName" class="form-control" placeholder="${lista[status.index+1]}" size="50" disabled="disabled"/></td>
                    </tr>

                    <tr>                        
                        <td><br>Edad:</td>
                    <br>
                    <td>
                        <br><input type="text" name="age" class="form-control" placeholder="${lista[status.index+2]}" size="" disabled="disabled"/></td>
                    </tr>

                    <tr>                        
                        <td><br>Estatura:</td>

                        <td>
                            <br><input type="text" name="height" class="form-control" placeholder="${lista[status.index+3]}" size="50" disabled="disabled"/></td>
                    </tr>

                    <tr>                        
                        <td><br>Peso:</td>

                        <td>
                            <br><input type="text" name="weight" class="form-control" placeholder="${lista[status.index+4]}" size="50" disabled="disabled"/></td>
                    </tr>

                    <tr>                        
                        <td><br>Posición de juego:</td>

                        <td>
                            <br><input type="text" name="position" class="form-control" placeholder="${lista[status.index+5]}" size="50" disabled="disabled"/></td>
                    </tr>

                    <tr>                        
                        <td><br>Fecha de nacimiento:</td>

                        <td>
                            <br><input type="text" name="born" class="form-control" placeholder="${lista[status.index+6]}" size="20" disabled="disabled"/></td>
                    </tr>

                    <tr>
                        <td><br>Foto:</td>

                        <td><br><input type="image" name="photo" size="50" placeholder="${imgData}" disabled="disabled"/></td>
                    </tr>
                    <tr>                        
                        <td colspan="2">
                            <br>
                    <center> <a class="btn-primary" style="vertical-align: 50px;" HREF="buscar.jsp"> REGRESAR </a></center>
                    </td>
                    </tr>

                </table>
            </form>
        </div>
    </center>
</body>
</html>
