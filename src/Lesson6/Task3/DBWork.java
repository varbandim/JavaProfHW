package Lesson6.Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWork {

    static Connection connection;
    static Statement stmt;
    private String path = "jdbc:sqlite:src/Lesson6/MainDB.db";

    public void connect(String path) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(path);
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
