<%-- 
    Document   : pruebas
    Created on : 10/04/2015, 02:22:05 PM
    Author     : jorgel.diaz
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
                        <td><input type="text" name="firstName" class="form-control" placeholder="Nombres"size="50"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class="btn btn-primary btn-block" type="submit" value="CONSULTAR">
                        </td>
                    </tr>
                </table>
            </form>
            <br>


        </div>
    </center>
</body>
</html>
