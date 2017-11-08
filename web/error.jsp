<%-- 
    Document   : error
    Created on : Oct 31, 2017, 9:48:07 AM
    Author     : Melnikov
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/error.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Произошкла ошибка!</h1>
        <div>${info}</div>
        <div>${error}</div>
    </body>
</html>
