<%-- 
    Document   : cadastroEmprestimo
    Created on : 17/11/2015, 23:31:49
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
        <form action="cadastrar" method="POST">
            <h1>Cadastro:</h1>
            <div>ID PRODUTO: <input type="number" name="IDProduto"></div>
            <div>email usuario: <input type="email" name="emailUsuarioAnunciador"></div>
            <div>Data Anuncio: <input type="text" name="dataAnuncio" pattern="[0-9][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"></div>
            <div>Data Inicial: <input type="text" name="dataInicial" pattern="[0-9][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"></div>
            <div>Data Final: <input type="text" name="DataFinal" pattern="[0-9][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"></div>
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
