<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Добавление Режиссёра</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1 class="header">Добавить Режиссёра</h1>
<%--<a class="buttoncenter" href="<c:url value="/dirList"/>"> Вернуться назад</a>--%>
<div class="description">
    <form action="/addDir" method="post">
        Введите имя Режиссёра </br>
        <input class="description" name="dirName" type="text" placeholder="Поное имя" class="textbox"> </br>
        <input class="description" type="submit" value="Добавить Режиссёра" class="button"/></br></br>
        <a class="description" href="<c:url value="/dirList"/>">Отмена</a>
    </form>
</div>
</body>
</html>
