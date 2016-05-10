<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="atualizar" method="POST">
            <h1>Atualizar:</h1>
            <div>Email: <input type="email" name="emailAtualizar"></div>
            <div>Nome: <input type="text" name="nome"></div>
            <div>Sobrenome: <input type="text" name="sobrenome"></div>
            <div>CPF: <input type="text" name="CPF"></div>
            <div>Senha: <input type="password" name="senha"></div>
            <div><input type="submit" value="Enviar"></div>
        </form>
    </body>
</html>
