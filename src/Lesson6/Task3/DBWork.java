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
    private static final String updateSql = "UPDATE Students SET mark = 15 WHERE name = 'Mark'";
    //добавление
    private static final String addSql = "INSERT INTO Students (name, mark) VALUES ('vasya', 18)";
    //получение счетчика данных
    private static final String count = "SELECT COUNT(*) AS CNT FROM Students";

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
    public void testBaseInsert() throws SQLException {
        //корректно добавляются
        result = stmt.executeQuery(count);
        int startCount = result.getInt("CNT");
        stmt.executeUpdate(addSql);
        result = stmt.executeQuery(count);
        if (!result.next()) {
            if (startCount + 1 != result.getInt("CNT")) {
                Assert.fail("Данные не добавляются");
            }
        }
    }

    @Test
    public void testBaseUpdate() throws SQLException {
        // обновляются
        int countUpdate = stmt.executeUpdate(updateSql);
        if (countUpdate == 0) {
            Assert.fail("Данные не обновляются");
        }
    }

    @Test
    public void testBaseRead() throws SQLException{
        //читаются записи
        result = stmt.executeQuery(readSql);
        if (result.next()) {
            Assert.fail("Данные не читаются");
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.rollback(point);
        connection.close();
    }
}
