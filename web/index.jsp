<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 05.03.2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Фильмотека</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <div class="nav">
  <a  href="<c:url value="/actorList"/>">Актёры</a></br>
  <a  href="<c:url value="/dirList"/>">Режиссёры</a></br>
  <a  href="<c:url value="/comList"/>">Кинокомпании</a></br>
  <a  href="<c:url value="/filmList"/>">Фильмы</a></br>
  </div>
  </body>
</html>
