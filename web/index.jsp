<%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 21/06/2019
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sistema Leilao</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

</head>
<body>
<div>
    <h1>Sistema Leilao</h1>
    <div class="row">
        <form action="/login" method="post" class="col s12">
            <div class="row">
                <div class="input-field col s6">
                    <input id="usuario" type="text" name="usuario" class="validate">
                    <label for="usuario">Usuário</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input id="senha" type="password" name="senha" class="validate">
                    <label for="senha">Senha</label>
                </div>
            </div>
            <div class="row">
                <button class="btn waves-effect waves-light" type="submit" name="action">Entrar</button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
