<%-- 
    Document   : consultaDataAnuncioEmprestimo
    Created on : 17/11/2015, 23:37:50
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
        <form action="consultar-por-data-anuncio" method="POST">
            <h1>Consulta:</h1>
            <div>Data de Anuncio: <input type="text" name="dataAnuncio" pattern="[0-9][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"></div>
          
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
