<%-- 
    Document   : seleccionar
    Created on : 17/04/2015, 05:00:45 PM
    Author     : jedisson.tapias
--%>
<%@ taglib prefix="jlib" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                
      
                <div style=" background-image: url(Resources/Contenido.jpg);position:relative; color: black;width: 49%; float: left;height:100%; ">
                    <h1>RESULTADO</h1>
                    
                    <form method="post" action="MostrarServlet" enctype="multipart/form-data">
                        <select name="jugador">
                        <jlib:forEach var="objeto" items="${lista}"><!-- Recorre la lista con los resultados de la busqueda-->
                            
                                <option value=${objeto[0]}>${objeto[1]} ${objeto[2]}</option>
                            
                            
                             <!--   <a href="Consulta.asp"> </a> <!-- Genera un hipervilculo a cada resultado-->
                            
                        </jlib:forEach>
                        </select>
                        <br>
                        <input type="submit" value="Enviar">
                    </form>
                    
                </div> 
        
                <div  style="position:relative; color: black;background: rgba(255, 255, 255, .5); width: 25%;float: left;height:100%;">
                    <br>
                    <b><Font size="4" color="Black">DESARROLLADORES</Font></b>                   
                    <br>
                    <Font size="4" color="black"><p><br><b>Mateo Noreña<br>Esteban Cataño<br>Jorge Diaz<br>John Tapias</b></p></Font>
                </div> 
                
                <br><br><br>
                <Font color="white"> <marquee>_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-</marquee></Font>
            </div>
            
        </div>
    </body> 
</html>
