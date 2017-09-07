package Lesson6.Task3;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class DBWork {
    private static Connection connection;
    private static Statement stmt;
    private static Savepoint point;
    private static ResultSet result;
    //чтение
    private static final String readSql = "SELECT * FROM Students";
    //обновление
    private static final String updateSql = "UPDATE INTO Students SET mark = 15 WHERE name = 'Mark'";
    //добавление
    private static final String addSql = "INSERT INTO Students (name, mark) VALUES ('vasya', 18)";


    //проинициализировать базу и создать точку возврата
    @BeforeClass
    public static void setConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/Lesson6/Task3/mainDB.db");
            stmt = connection.createStatement();
            point = connection.setSavepoint("Before");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBase() throws SQLException {
        //корректно добавляются
        result = stmt.executeQuery(addSql);
        if (!result.next()) {
            Assert.fail("Данные не добавляются");
        }

        // обновляются
        result = stmt.executeQuery(updateSql);
        if (!result.next()) {
            Assert.fail("Данные не обновляются");
        }

        //читаются записи
        result = stmt.executeQuery(readSql);
        if (!result.next()) {
            Assert.fail("Данные не читаются");
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.rollback(point);
        connection.close();
    }
}
