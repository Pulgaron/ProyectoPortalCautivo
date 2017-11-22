<%-- 
    Document   : Formulario
    Created on : 20/11/2017, 07:10:09 PM
    Author     : oscar
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
    <h1>UNIVERSIDAD VERACRUZANA</h1>
    <img src="uv.png" alt="Logotipo Universidad Veracruzana" height="230">
    <div class="formulario">
        <form action="inicio" method="post" >
            <p> ¿Eres maestro o alumno?  </p>
        
                <input type="radio" name="tipo" value="2" required> Maestro
                <input type="radio" name="tipo" value="1"required > Alumno
        
            <br>
            <p>Introduce tu matricula: <input type="text" name="matricula" value="" placeholder="matricula" required>
            </p> <br> 
            <p>¿Que servicio será utilizado en esta maquina?  </p>
                <ul>
                 <i><input type="radio" name="servicio" value="1"> Internet</i><br><br>
                  <i><input type="radio" name="servicio" value="2"> Software</i><br><br>
                  <i><input type="radio" name="servicio" value="3"> Ocio</i><br><br>
                  <i><input type="radio" name="servicio" value="4"> Otro</i><br></i>
             </ul>
         <button type="submit">Acceder</button>
        </form>

    </div>
  </center>
</body>
</html>
