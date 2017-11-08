<%-- 
    Document   : admin
    Created on : Nov 2, 2017, 8:21:44 AM
    Author     : Melnikov
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Привет администратор ${reguser.customer.name}!</h1>
        <div>${info}</div>
        <div>${error}</div>
        Пользователи:
        <form action="controller?command=addRole">
            <select name="users">
                <c:forEach var="user" items="${users}">
                    <option value="${user.id}">${user.customer.name} ${user.customer.surname}: login ${user.login}</option>
                </c:forEach>
            </select>
            <select name="role" >
                <c:forEach var="role" items="${roles}">
                    <option value="${role}">${role}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Назначить">
        </form>
    </body>
</html>
