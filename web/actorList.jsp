<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 03.04.2019
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" contentType="text/html;charset=UTF-8"
         %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Актёры</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="topnav">
    <a class="topnavActive" href="<c:url value="/actorList"/>">Актёры</a>
    <a href="<c:url value="/dirList"/>">Режиссёры</a>
    <a href="<c:url value="/comList"/>">Кинокомпании</a>
    <a href="<c:url value="/filmList"/>">Фильмы</a>
</div>
<table class="table" align="center">
    <thead>

    <td>Полное имя</td>
    <td>Редактирование</td>
    <td>Удаление</td>
    </thead>
    <tbody>
<c:forEach items="${actors}" var="actor">
    <tr>
        <td>${actor.actorName}</td>
        <td><a href="/editActor?actorId=${actor.actorId}">Редактировать</a></td>
        <td><a href="/deleteActor?actorId=${actor.actorId}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<a class="button" href="addActor.jsp">Добавить</a>
</body>
</html>
