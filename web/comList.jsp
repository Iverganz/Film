<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" contentType="text/html;charset=UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Кинокомпании</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="topnav">
    <a href="<c:url value="/actorList"/>">Актёры</a>
    <a href="<c:url value="/dirList"/>">Режиссёры</a>
    <a class="topnavActive" href="<c:url value="/comList"/>">Кинокомпании</a>
    <a href="<c:url value="/filmList"/>">Фильмы</a>
</div>
<table class="table" align="center">
    <thead>
    <td>Название</td>
    <td>Редактирование</td>
    <td>Удаление</td>
    </thead>
    <tbody>
    <c:forEach items="${companies}" var="com">
    <tr>
        <td>${com.comName}</td>
        <td><a href="/editCom?comId=${com.comId}">Редактировать</a></td>
        <td><a href="/deleteCom?comId=${com.comId}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<a class="button" href="addCom.jsp">добавить</a>
</body>
</html>
