<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Редактирование Актёра</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="editActor" method="post">
    Id </br>
    <input name="actorId" type="text" value="${actorToEdit.actorId}" class="textbox" readonly> </br>
    Имя </br>
    <input name="actorName" type="text" value="${actorToEdit.actorName}" class="textbox"> </br>
    <input type="submit" value="Сохранить изменения" class="button"/>
    <a class="description" href="<c:url value="/actorList"/>">Отмена</a>
</form>
</body>
</html>
