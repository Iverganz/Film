<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 16.04.2019
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Актёрский состав ${film.filmName}</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="description">
    <form action="/addRole" method="post">
        Выберите Актёра</br>
        <select class="description" name="actorSelect">
            <c:forEach items="${actors}" var="actor">
                <option value=${actor.actorId}>${actor.actorName}
                </option>
            </c:forEach>
        </select>
        Введите роль</br>
        <input name="roleName" type="text" placeholder="Role Name" class="textbox"> </br>
        <input type="submit" value="Добавить роль в состав" class="button"/></br></br>
        <a href="<c:url value="/roleList?filmId=${film.idFilm}"/>">Отмена</a>
    </form>
</div>
</body>
</html>
