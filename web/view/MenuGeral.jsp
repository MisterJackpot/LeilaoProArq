<%@ page import="DTO.UsuarioDTO" %><%--
  Created by IntelliJ IDEA.
  User: Gabriel Loff
  Date: 21/06/2019
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sistema Leilao</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="../css/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="../css/mystyle.css"  media="screen,projection"/>
    <% UsuarioDTO cliente = (UsuarioDTO) request.getSession().getAttribute("cliente");%>
</head>
<body>
<nav>
    <div class="main nav-wrapper">
        <a href="menu" class="brand-logo">Sistema Leilões</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="logout">Logout</a></li>
        </ul>
    </div>
</nav>
<script type="text/javascript" src="../js/materialize.min.js"></script>
