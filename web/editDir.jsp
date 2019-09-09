<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Редактирование</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="description">
<form action="editDir" method="post">
    ID </br>
    <input name="dirId" type="text" value="${dirToEdit.dirId}" class="textbox" readonly> </br>
    Полное имя </br>
    <input name="dirName" type="text" value="${dirToEdit.dirName}" class="textbox"> </br>
    <input type="submit" value="Сохранить изменения" class="button"/></br></br>
    <a href="<c:url value="/dirList"/>">Отмена</a>
</form>
</div>
</body>
</html>
