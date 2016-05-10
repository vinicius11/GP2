<%-- 
    Document   : cadastro
    Created on : 04/11/2015, 10:14:40
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
        <h1>Cadastro de Usuario!</h1>
        <form action="cadastrar" method="POST">
            <div>Nome:<input type="text" name="nome"> </div>
            <div>Sobrenome:<input type="text" name="sobrenome"></div>
            <div>Cpf:<input type="text" name="CPF"></div>
            <div>Email:<input type="text" name="email"></div>
            <div>Senha:<input type="password" name="senha"></div>
         <div><input type="submit" value="Enviar"></div>
        </form>       
    </body>
            


</html>
