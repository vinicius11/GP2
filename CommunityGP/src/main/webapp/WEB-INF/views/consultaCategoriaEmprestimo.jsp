<%-- 
    Document   : consultaCategoriaEmprestimo
    Created on : 17/11/2015, 23:35:52
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
            <h1>Consulta:</h1>
            <div>categoria: <input type="text" name="nomeCategoria"></div>
          
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
