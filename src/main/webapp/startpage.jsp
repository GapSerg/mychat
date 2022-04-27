<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
     <link rel="stylesheet" href="css/misite.css">
</head>
<body>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>Hello, you can join to chat!  </h1>
        <div class="registration-cssave">
            <form action = "ToMainPageServlet" method = "GET">
                <h3 class="text-center">Форма входа</h3>
                <div class="form-group">
                    <input class="form-control item" type="text" name="name" maxlength="15" minlength="4" pattern="^[a-zA-Z0-9_.-]*$" id="username" placeholder="Логин" required>
                </div>
                <div class="form-group">
                    <input class="form-control item" type="password" name="pass" minlength="3" id="password" placeholder="Пароль" required>
                </div>

                <div class="form-group">
                                    <label class="form-control item">
                                     <%   String attentionMessage;
                                         if (session.getAttribute("attentionMessage")!=null){

                                          attentionMessage= (String )session.getAttribute("attentionMessage");
                                          session.setAttribute("attentionMessage",null);}
                                         else { attentionMessage="";}
                                            %>
                                            <%= attentionMessage%>
                                            </label>
                </div>


                <div class="form-group">
                    <button class="btn btn-primary create-account" type="submit" >Вход в аккаунт</button>
                </div>
                <div class="form-group">
                     <button class="btn btn-primary registration" type="button" onClick='location.href="/registration"' >Регистрация</button>
                </div>
            </form>
        </div>
</body>
</html>
