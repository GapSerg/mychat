package servlets;

import classes.DataBaseWork;
import classes.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    public static HttpSession session;
    @Override
    public void init(){

    }
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthDate = request.getParameter("birthdate");
        String pass = request.getParameter("pass");
        DataBaseWork.addUser(name, email, birthDate, pass);
        User curentUser= DataBaseWork.getUser(name, pass);

        session.setAttribute("user", curentUser);
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {


        response.sendRedirect(request.getContextPath() + "/main");




    }
}