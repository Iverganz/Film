<%--
  Created by IntelliJ IDEA.
  User: пользователь
  Date: 08.04.2019
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Редактирование Кинокомпании</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="editCom" method="post">
    ID </br>
    <input name="comId" type="text" value="${comToEdit.comId}" class="textbox" readonly> </br>
    Название </br>
    <input name="comName" type="text" value="${comToEdit.comName}" class="textbox"> </br>
    <input type="submit" value="Сохранить изменения" class="button"/></br></br>
    <a href="<c:url value="/comList"/>">Отмена</a>
</form>
</body>
</html>
