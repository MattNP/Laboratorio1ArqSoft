<%-- 
    Document   : busqueda
    Created on : 17/04/2015, 02:18:55 PM
    Author     : jedisson.tapias
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
        <link rel="stylesheet" href="botones.css">
        <title>Álbum Virtual</title>
    </head>
    <body background="Resources/Estadio.jpg" >
        
        <div align="center" style="margin: 5%;" >
            
            <div align="center" style="color: White;background: rgba(0, 0, 0, .5);border: 1px solid black;width: 80%;margin: 5%;">
                <br>
                <B><font size=20>Álbum Virtual</font></B>
                <br>
            </div>
            
            <br />
            <br>
            <br>
            <br>
            <div align="center" style="color: #FF00FF; width: 75%;height:500px;background-color: transparent;">
                
                <div style="position:relative;float: left;width: 25%;height:100%;display: table;background: rgba(255, 255, 255, .5);">
                    <div  style="position:relative;color: #FF00FF;background:white;  width:80%; vertical-align: middle;display: table-cell;background-color: transparent;" >
                    <!--<button  style="color:white ;font-family: sans-serif;font-size: 24px;font-weight: bold;background:#bf1b04;box-shadow: 0px 5px 0 #8F1502;border-radius: 50px;border:0;transition: all 0.20s linear;-webkit-transition: all 0.20s linear;-moz-transition: all 0.20s linear; position:relative;bottom:0;width: 100px;height: 40px;vertical-align: 30px;">Inicio</button><br>-->
                    <a class="button beige" style="vertical-align: 50px;"HREF="index.html">   Inicio   </a><br>
                    <a class="button beige" style="vertical-align: 50px;"HREF="Ingreso.jsp">Ingresar</a><br>
                    <a class="button beige" style="vertical-align: 50px; "HREF="Busqueda.jsp"> Buscar </a><br>
                    </div>
                </div>
                
      
                <div style=" background-image: url(Resources/Contenido.jpg);position:relative; color: #FF00FF;width: 49%; float: left;height:100%; ">
                    <center>
        <div style= "color:white;font-family: sans-serif;">
            <h1>INGRESO DE JUGADOR</h1>
            <form method="post" action="SubirServlet" enctype="multipart/form-data">
                <table border="0">
                    <tr>
                    <td><b>Nombres: </b></td>
                        <td><input type="text" name="firstName" class="form-control" placeholder="Nombres"size="15"/></td>
                    </tr>
                    <tr>
                        <td><b><br>Apellidos: </b></td>

                        <td>
                            <br><input type="text" name="lastName" class="form-control" placeholder="Apellidos"size="15"/></td>
                    </tr>

                    <tr>                        
                        <td><b><br>Edad: </b></td>
                    <br>
                    <td>
                        <br><input type="text" name="age" class="form-control" placeholder="Edad"size="10"/></td>
                    </tr>

                    <tr>                        
                       <td><b><br>Estatura: </b></td>
                    
                    <td>
                        <br><input type="text" name="height" class="form-control" placeholder="Estatura (cm)"size="10"/></td>
                    </tr>
                    
                    <tr>                        
                        <td><br><b>Peso:</b></td>
                    
                    <td>
                        <br><input type="text" name="weight" class="form-control" placeholder="Peso (kg)"size="10"/></td>
                    </tr>
                    
                    <tr>                        
                        <td><br><b>Posición de juego:</b></td>
                    
                    <td>
                        <br><input type="text" name="position" class="form-control" placeholder="(ARQUERO,DEFENSA,VOLANTE,DELANTERO)"size="15"/></td>
                    </tr>
                    
                    <tr>                        
                        <td><br><b>Fecha de nacimiento:</b></td>
                    
                    <td>
                        <br><input type="date" name="born" class="form-control" placeholder="Fecha de nacimiento"size="15"/></td>
                    </tr>
                    
                    <tr>
                        <td><br><b>Foto:</b></td>

                        <td><br><input type="file" name="photo" size="10"/></td>
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
                </div> 
        
                <div  style="position:relative; color: black;background: rgba(255, 255, 255, .5); width: 25%;float: left;height:100%;">
                    <br>
                    <b><Font size="4" color="Black">DESARROLLADORES</Font></b>                   
                    <br>
                    <Font size="4" color="black"><p><br><b>Mateo Noreña<br>Esteban Cataño<br>Jorge Diaz<br>John Tapias</b></p></Font>
                </div> 
            </div>
    </body> 
</html>
