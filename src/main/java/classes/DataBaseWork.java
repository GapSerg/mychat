package classes;

import java.sql.*;
import java.util.concurrent.ConcurrentLinkedDeque;


public class DataBaseWork {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/userchat";




    public static void addUser(String name, String email, String birthDate, String pass) {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("insert into userchat.users (name, email, birthdate, password) " +
                    "value (\"" + name + "\", \"" + email + "\", \"" + birthDate + "\", \"" + pass + "\")");

        } catch (SQLException throwable) {
            System.out.println("No connection with Data Base userchat");


        }

    }

    public static User getUser(String name, String password) {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from users where password=" + password + " and name=\"" + name + "\"");
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String email = resultSet.getString(3);
                String birthDate = resultSet.getString(5);
                System.out.println(new User(userId, name, email, birthDate, password));
                return new User(userId, name, email, birthDate, password);
            } else return null;


        } catch (SQLException throwables) {
            System.out.println("No connection with Data Base userchat for read");
        }
        return null;
    }

    public static void addMessage(int userId, String text, String branch) {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("insert into userchat.messages (userid, text, branch) " +
                    "value (\"" + userId + "\", \"" + text + "\", \"" + branch + "\")");

        } catch (SQLException throwable) {
            System.out.println("No connection with Data Base userchat table messages");


        }

    }

    public static ConcurrentLinkedDeque<Message> getLastMessage(int countMessage) {
        ConcurrentLinkedDeque<Message> messages = new ConcurrentLinkedDeque<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT A.id, B.name, text, branch, postdate FROM messages as A " +
                    "LEFT JOIN users as B ON (A.userid = B.id) ORDER BY postdate DESC LIMIT " + countMessage);


            while (resultSet.next()) {
                int MessageId = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String textMessage = resultSet.getString(3);
                String branch = resultSet.getString(4);
                String postDate = resultSet.getString(5);

                Message message = new Message(MessageId, userName, textMessage, branch, postDate);
                messages.addFirst(message);
            }



        } catch (SQLException throwables) {
            System.out.println("No connection with Data Base userchat for read");
        }
        return messages;

    }



}
