package servlets;

import classes.DataBaseWork;
import classes.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MainPageServlet  extends javax.servlet.http.HttpServlet {
    private ConcurrentLinkedDeque<Message> messages;
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        messages= DataBaseWork.getLastMessage(10);
        session.setAttribute("messages", messages);
        getServletContext().getRequestDispatcher("/mainpagechat.jsp").forward(request, response);

    }


}
