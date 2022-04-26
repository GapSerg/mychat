package servlets;

import classes.DataBaseWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToMainPageServlet extends javax.servlet.http.HttpServlet {


    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        session.setAttribute("user", DataBaseWork.getUser(name, pass));
        session.setAttribute("text", DataBaseWork.getLastMessage(10));
        response.sendRedirect(request.getContextPath() + "/main");


    }
}