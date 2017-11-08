<%-- 
    Document   : registration
    Created on : Oct 9, 2017, 9:21:36 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Регистрация</h1>
        <form name="registration" action="controller?command=addNewUser" method="POST">
            Имя: <input type="text" name="name" value="Pupil"><br>
            Фамилия: <input type="text" name="surname" value="Pupil"><br>
            Телефон: <input type="text" name="tel" value="2323232323"><br>
            Город: <input type="text" name="city" value="Johvi"><br>
            Начальная сумма: <input type="text" name="money" value="1000"><br>
            Логин: <input type="text" name="login" value="pupil"><br>
            Пароль: <input type="password" name="password1" value="123"><br>
            Повторите пароль: <input type="password" name="password2" value="123"><br>
            Имя: <input type="submit" value="Зарегистрировать">
        </form>
    </body>
</html>
