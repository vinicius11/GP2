<%-- 
    Document   : consultaPorCategoriaProduto
    Created on : 16/11/2015, 12:01:35
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
        <form action="consultar-por-categoria" method="POST">
            <h1>Consulta</h1>
            <div>Nome da Categoria: <input type="text" name="nome"></div>
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
