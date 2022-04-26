package classes;

import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws SQLException {

        DataBaseWork bd = new DataBaseWork();
      //  bd.addUser("Ivan", "test@tut.by", "1990-05-06", "12345");

        System.out.println(DataBaseWork.getLastMessage(5));


    }
}
