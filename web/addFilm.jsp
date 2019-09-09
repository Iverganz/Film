<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Film</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1 class="header">Add Film</h1>
<a class="buttoncenter" href="<c:url value="/actorList"/>"> Вернуться назад</a>
<div class="description">

    <form action="/addFilm" method="post">
        Введите название Фильма </br>
        <input  name="filmName" type="text" placeholder="Film title" class="textbox"> </br>
        Выберите Режиссёра</br>
        <select class="description" name="dirSelector">
            <c:forEach items="${directors}" var="t">
                <option value=${t.dirId}>${t.dirName}
                </option>
            </c:forEach>
        </select></br>
    Выберите Кинокомпанию</br>
    <select class="description" name="comSelector">
        <c:forEach items="${companies}" var="t">
            <option value=${t.comId}>${t.comName}
            </option>
        </c:forEach>
    </select></br>
    Дата премьеры </br>
    <input name="premier" type="date"></br>
        <input type="submit" value="Добавить фильм" class="button"/></br></br>
        <a href="<c:url value="/filmList"/>">Отмена</a>
    </form>
</div>
</body>
</html>
