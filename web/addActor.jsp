<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 03.04.2019
  Time: 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Добавление Актёра</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%--<a class="buttoncenter" href="<c:url value="/actorList"/>"> Вернуться назад</a>--%>
<div class="description">
    <form action="/addActor" method="post">
        Введите имя Актёра </br>
        <input class="description" name="actName" type="text" placeholder="Полное имя" > </br>
        <input type="submit" value="Добавить Актёра" class="button"/></br></br>
        <a class="description" href="<c:url value="/actorList"/>">Отмена</a>
    </form>

</div>
</body>
</html>
