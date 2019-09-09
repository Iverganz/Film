<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 13.04.2019
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" contentType="text/html;charset=UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${film.filmName} cast</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="topnav">
    <a href="<c:url value="/actorList"/>">Актёры</a>
    <a href="<c:url value="/dirList"/>">Режиссёры</a>
    <a href="<c:url value="/comList"/>">Кинокомпании</a>
    <a href="<c:url value="/filmList"/>">Фильмы</a>
</div>
<h1>${film.filmName} cast</h1>
<table class="table" align="center">

    <thead>
    <td>Актёр</td>
    <td>Роль</td>
    <td>Редактирование</td>
    <td>Удаление</td>
    </thead>
    <tbody>
    <c:forEach items="${roles}" var="role">
    <tr>
        <td>${role.key.actorName}</td>
        <td>${role.value}</td>
        <td><a href="/editRoles?actorId=${role.key.actorId}&filmId=${film.idFilm}">Редактировать</a></td>
        <td><a href="/deleteRole?actorId=${role.key.actorId}&filmId=${film.idFilm}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<a class="button" href="/addRole?filmId=${film.idFilm}">добавить</a>
</body>
</html>
