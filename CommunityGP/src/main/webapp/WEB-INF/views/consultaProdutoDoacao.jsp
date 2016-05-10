<%-- 
    Document   : consultaProdutoDoacao
    Created on : 08/12/2015, 22:32:12
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
        <h1>Hello World!</h1>
        <form action="consultar-por-produto" method="POST">
            <h1>Consulta:</h1>
            <div>Nome do Produto: <input type="text" name="nomeProduto"></div>
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
