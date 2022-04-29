package servlets;

import classes.DataBaseWork;
import classes.Message;
import classes.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ToMainPageServlet extends javax.servlet.http.HttpServlet {
    private ConcurrentLinkedDeque<Message> messages;

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        User currentUser = DataBaseWork.getUser(name, pass);
        if (currentUser!=null){
            session.setAttribute("user", currentUser);

            response.sendRedirect(request.getContextPath() + "/main");

        }
        else {
            session.setAttribute("attentionMessage", "Такого пользователя нет");
            getServletContext().getRequestDispatcher("/start").forward(request, response);
        }






    }
}