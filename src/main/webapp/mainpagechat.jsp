<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language ="java" %>


<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title> Чатик </title>
  <link  href="css/mycss.css" type="text/css" rel="stylesheet"/>

  </head>
<body>



        <p id="menuStyle"> Сообщения нашего чата:</p>
        <pre><%=(String) session.getAttribute("text")%>
        </pre>

    <form action="NewMessage" method="post" >
      <p id="menuMessage"><b>  Введите ваше сообщение,
                                <%@ page import="classes.User"   %>
                                <% User user = (User) session.getAttribute("user");
                                String name = user.getName();
                                %>
                                <%=name%>:
        </b></p>
      <p><textarea rows="5" cols="45" name="text"></textarea></p>

      <p><input type="submit" value="Отправить"></p>
     </form>

        <form action = "Quit" method = "GET">
        <input type = "submit" value = "Quit" />
        </form>



</body>
</html>
