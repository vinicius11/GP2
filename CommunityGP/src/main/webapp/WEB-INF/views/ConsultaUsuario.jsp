<%-- 
    Document   : ConsultarUsuario
    Created on : 18/11/2015, 22:22:52
    Author     : Vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consultar Usuario!</h1>
        <form action="consultarPorEmail" method="POST">
            <div>Email: <input type="email" name="email"></div>
            <div> <input type="submit" name="Enviar"></div>
        </form>
    </body>
</html>
