<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 13.04.2019
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${role.role}</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="description">
    <%--<input name="idFilm" value="${film.idFilm}" readonly>--%>
    <%--<h1>${film.filmName}</h1>--%>
    <form action="/editRoles" method="post">
        Выберите Актёра</br>
        <select class="description" name="actorSelect">
            <option value="${role.idActor}">${actorDAO.getActor(role.idActor).actorName}</option>
            <c:forEach items="${actors}" var="actor">
                <option value=${actor.actorId}>${actor.actorName}
                </option>
            </c:forEach>
        </select>
        Введите роль</br>
        <input class="description" name="roleName" type="text" placeholder="Role Name" value="${role.role}" class="textbox"> </br>
        <input class="description" type="submit" value="Сохранить изменения" class="button"/></br></br>
        <a class="description" href="<c:url value="/roleList?filmId=${film.idFilm}"/>">Отмена</a>
    </form>
</div>
</body>
</html>
