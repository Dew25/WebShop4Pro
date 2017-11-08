<%-- 
    Document   : product
    Created on : Oct 31, 2017, 9:32:11 AM
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
        <h1>Наши продукты:</h1>
        <div>${info}</div>
        <div>${error}</div>
        <img src="resources/images/karb.jpg">
        <ul>
            <c:forEach var="product" items="${products}">
                <li>
                    ${product.name}, по цене ${product.price/100} EUR - ${product.quantity} шт.
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
