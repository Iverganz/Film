<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" contentType="text/html;charset=UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Фильмы</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="topnav">
    <a href="<c:url value="/actorList"/>">Актёры</a>
    <a href="<c:url value="/dirList"/>">Режиссёры</a>
    <a href="<c:url value="/comList"/>">Кинокомпании</a>
    <a class="topnavActive" href="<c:url value="/filmList"/>">Фильмы</a>
</div>
<table class="table" align="center">
    <thead>
    <td>Название</td>
    <td>Режиссёр</td>
    <td>Кинокомпания</td>
    <td>Премьера</td>
    <td>Актёрский Состав</td>
    <td>Редактирование</td>
    <td>Удаление</td>
    </thead>
    <tbody>
    <c:forEach items="${films}" var="film">
    <tr>
        <td>${film.filmName}</td>
        <td>${directorDAO.getDirector(film.getIdDir()).getDirName()}</td>
        <td>${companyDAO.getCompany(film.getIdCompany()).getComName()}</td>
        <td>${film.premier}</td>
        <td>
            <c:forEach items="${filmActorDAO.getActorsByFilm(film.idFilm)}" var="role">
                <p>${role.key.actorName}</p>
                <p>...${role.value}</p>
            </c:forEach>
            <a href="/roleList?filmId=${film.idFilm}">Подробнее..</a>
        </td>
        <td><a href="/editFilm?filmId=${film.idFilm}">Редактировать</a></td>
        <td><a href="/deleteFilm?filmId=${film.idFilm}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</br>
<a class="button" href="/addFilm">добавить</a>
</body>
</html>
