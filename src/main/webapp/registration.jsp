<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
     <link rel="stylesheet" href="css/misite.css">
</head>
<body>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>Now you can registration in chat </h1>
        <div class="registration-cssave">
            <form action = "SetUser" method = "POST">
                <h3 class="text-center">Введите ваши данные</h3>
                <div class="form-group">
                    <input class="form-control item" type="text" name="name" maxlength="15" minlength="4" pattern="^[a-zA-Z0-9_.-]*$" id="username" placeholder="Имя (логин)" required>
                </div>
                <div class="form-group">
                    <input class="form-control item" type="text" name="email" minlength="6" pattern="^[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-z]{2,}" id="email" placeholder="e-mail" required>
                </div>
                <div class="form-group">
                      <input class="form-control item" type="text" name="birthdate" maxlength="10" minlength="10" pattern="[0-9]{4}-[0,1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}" id="birthdate" placeholder="Дата рождения" required>
                </div>
                <div class="form-group">
                      <input class="form-control item" type="password" name="pass" minlength="3" id="password" placeholder="Пароль" required>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary create-account" type="submit">Зарегистрироваться</button>

            </form>
        </div>
</body>
</html>