<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Редактировать фильм</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1 class="header">Edit Film</h1>
<a class="buttoncenter" href="<c:url value="/actorList"/>"> Вернуться назад</a>
<div class="description">

    <form action="/editFilm" method="post">
        <input name="filmId" type="text" placeholder="Film title" value="${film.idFilm}" class="textbox" readonly>
        Введите название Фильма </br>
        <input name="filmName" type="text" placeholder="Film title" value="${film.filmName}" class="textbox"> </br>
        Выберите Режиссёра</br>
        <select class="description" name="dirSelector">
            <option value=${film.idDir}>${dirDAO.getDirector(film.idDir).dirName}</option>
            <c:forEach items="${directors}" var="t">
                <option value=${t.dirId}>${t.dirName}
                </option>
            </c:forEach>
        </select></br>
        Выберите Кинокомпанию</br>
        <select class="description" name="comSelector">
            <option value=${film.idCompany}>${coDAO.getCompany(film.idCompany).comName}</option>
            <c:forEach items="${companies}" var="co">
                <option value=${co.comId}>${co.comName}
                </option>
            </c:forEach>
        </select></br>
        Дата премьеры </br>
        <input name="premier" type="date" value="${film.premier}"></br>
        <input type="submit" value="Сохранить изменения" class="button"/></br></br>
        <a href="<c:url value="/filmList"/>">Отмена</a>
    </form>
</div>
</body>
</html>
