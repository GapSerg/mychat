package servlets;

import classes.DataBaseWork;
import classes.Message;
import classes.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AddMessageServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void init(){

    }

@Override
protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    String messageText = request.getParameter("text");
    User curentUser= (User) session.getAttribute("user");
    if (curentUser!=null) {
        DataBaseWork.addMessage(curentUser.getId(), messageText, "main");

    }
    doGet(request, response);


        }

@Override
protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
        throws ServletException, IOException {


          response.sendRedirect(request.getContextPath() + "/main");

        }

        }
