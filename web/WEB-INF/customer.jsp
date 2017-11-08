<%-- 
    Document   : customer
    Created on : Nov 7, 2017, 8:27:47 AM
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
        <h1>Наши покупатели:</h1>
        <div>${info}</div>
        <div>${error}</div>
        <img src="resources/images/customers.jpg">
        <ul>
            <c:forEach var="customer" items="${customers}">
                <li>
                    ${customer.name} ${customer.surname}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>