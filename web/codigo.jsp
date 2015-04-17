<%-- 
    Document   : codigo
    Created on : 17/04/2015, 05:02:29 PM
    Author     : jedisson.tapias
--%>

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
                    <a class="button beige" style="vertical-align: 50px;"HREF="ingresar.jsp">Ingresar</a><br>
                    <a class="button beige" style="vertical-align: 50px; "HREF="buscar.jsp"> Buscar </a><br>
                    <a class="button beige" style="vertical-align: 50px;"HREF="codigo.jsp"> Código </a>
                    </div>
                </div>
                
      
                <div style=" background-image: url(Resources/Contenido.jpg);position:relative; color: black;width: 49%; float: left;height:100%; ">
                    <h2>Titulo</h2>
                    <p>Ingresar codigo de servlet #1</p>
                    <p>Ingresar codigo de servlet #2<</p>
                </div> 
        
                <div  style="position:relative; color: black;background: rgba(255, 255, 255, .5); width: 25%;float: left;height:100%;">
                    <br>
                    <b><Font size="4" color="Black">DESARROLLADORES</Font></b>                   
                    <br>
                    <Font size="4" color="black"><p><u><b>Back-end</b></u><br>>>Mateo Noreña</p></Font>
                    <Font size="4" color="black" ><p><u><b>Middle-end</b></u><br>>>Esteban Cataño<br>>>Jorge Diaz</p></Font>
                    <Font size="4" color="black" ><p><u><b>Front-end</b></u><br>>>John Tapias</p></Font>
                    
                </div>  
                <br><br><br>
                <Font color="white"> <marquee>_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-_-*-</marquee></Font>
            </div>
            
        </div>
    </body> 
</html>