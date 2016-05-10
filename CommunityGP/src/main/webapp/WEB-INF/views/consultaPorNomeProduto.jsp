<%-- 
    Document   : consultaProduto
    Created on : 16/11/2015, 11:27:22
    Author     : elisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="consultar-por-nome" method="POST">
            <h1>Consulta</h1>
            <div>Nome: <input type="text" name="nome"></div>
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
