<%-- 
    Document   : Doacao
    Created on : 29/11/2015, 21:02:25
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
        <h1>Doacao!</h1>
        <form action="interessadoDoacao" method="POST">
            <div> ID Doacao: <input type="text" name="id"></div>
            <div> Email:<input type="email" name="email"> </div> 
            <!--<div> Data:<input type="date" name="dataAnuncio"></div> -->
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
