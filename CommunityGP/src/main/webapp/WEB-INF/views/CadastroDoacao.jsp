<%-- 
    Document   : cadastroDoacao
    Created on : 16/11/2015, 13:47:37
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
        <h1>Cadastro Doacao!</h1>
        <form action="cadastrar" method="POST">
            <div> Nome Produto: <input type="text" name="nome"></div>
            <div> Estado Produto: <input type="text" name="estado"></div>
        <!-- <div> Id do Produto: <input type="text" name="id"></div> -->
            <div> Nome da Categoria:<input type="text" name="nomeCategoria"></div>
            <div> Email:<input type="email" name="emailUsuario"> </div> 
            <div> Data:<input type="text" name="dataAnuncio" pattern="[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"></div> 
            <div><input type="submit" value="Enviar"></div>
        </form>    
    </body>
</html>
