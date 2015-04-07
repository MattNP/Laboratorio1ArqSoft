<%-- 
    Document   : upload
    Created on : 6/04/2015, 03:30:34 PM
    Author     : esteban.catanoe
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div class="container well">
            <h1>Álbum Virtual</h1>
            <form method="post" action="SubirServlet" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                        <td>Nombres: </td>
                        <td><input type="text" name="firstName" class="form-control" placeholder="Nombres"size="50"/></td>
                    </tr>
                    <tr>
                        <td><br>Apellidos: </td>
                    
                    <td>
                        <br><input type="text" name="lastName" class="form-control" placeholder="Apellidos"size="50"/></td>
                    </tr>
                    
                    <tr>                        
                        <td><br>Edad:</td>
                    <br>
                    <td>
                        <br><input type="text" name="age" class="form-control" placeholder="Edad"size="50"/></td>
                    </tr>
                    
                    <tr>                        
                        <td><br>Estatura:</td>
                    <br>
                    <td>
                        <br><input type="text" name="size" class="form-control" placeholder="Estatura"size="50"/></td>
                    </tr>

                    <tr>
                        <td><br>Foto:</td>

                        <td><br><input type="file" name="photo" size="50"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class="btn btn-primary btn-block" type="submit" value="Guardar">
                        </td>
                    </tr>
                </table>
            </form>
            <br>


        </div>
    </center>
</body>
</html>

