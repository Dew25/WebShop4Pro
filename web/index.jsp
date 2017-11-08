<%-- 
    Document   : index
    Created on : Oct 31, 2017, 9:32:41 AM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/index.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добро пожаловать!</h1>
        <div>${info}</div>
        <div>${error}</div>
        
        <a href="controller?command=login">Войти</a><br>
        <a href="controller?command=logout">Выйти</a><br>
        <c:if test="${enterUser}">
            <a href="controller?command=product">Продукты</a><br>
            <a href="controller?command=customer">Пользователи</a><br>
            <a href="controller?command=admin">admin</a><br>
        </c:if>
        
    </body>
</html>
