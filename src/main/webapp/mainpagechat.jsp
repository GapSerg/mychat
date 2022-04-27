<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language ="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title> Чатик </title>
  <link  href="css/mycss.css" type="text/css" rel="stylesheet"/>

  </head>
<body>


    <c:forEach var="message" items="${sessionScope.messages}">
  <ul>

          <li>Имя: <c:out value="${message}"/></c> </li>

 </ul>
      <hr />

     </c:forEach>




    <form action="NewMessage" method="post" >
      <p id="menuMessage"><b>  Введите ваше сообщение,
                                <%@ page import="classes.User"   %>
                                <% User user = (User) session.getAttribute("user");

                                String name;
                                 if (user!=null){
                                 name= user.getName();}
                                 else name="";
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
