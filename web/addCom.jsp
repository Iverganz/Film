<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Добавление Кинокомпании</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1 class="header">Добавить Кинокомпанию</h1>
<a class="buttoncenter" href="<c:url value="/comList"/>"> Вернуться назад</a>
<div class="description">
    <form action="/addCom" method="post">
        Введите имя Актёра </br>
        <input class="description" name="comName" type="text" placeholder="Название" class="textbox"> </br>
        <input type="submit" value="Добавить Компанию" class="button"/></br></br>
        <a class="description" href="<c:url value="/comList"/>">Отмена</a>
    </form>
</div>
</body>
</html>
