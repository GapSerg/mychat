package servlets;

import classes.DataBaseWork;
import classes.Message;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ConcurrentLinkedDeque;

@WebListener
public class ContextListener implements ServletContextListener {

    private ConcurrentLinkedDeque<Message> messages;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext = servletContextEvent.getServletContext();

        messages= DataBaseWork.getLastMessage( 10);

        servletContext.setAttribute("messages", messages);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        messages = null;
    }
}