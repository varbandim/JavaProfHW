package Lesson6.Task3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/*
Написать тесты для
проверки того, что при работе с базой корректно добавляются, обновляются и читаются
записи. Следует учесть что в базе есть заранее добавленные записи, и после проведения
тестов эти записи не должны быть удалены/изменены/добавлены.
 */
public class TestDB {
   private static Connection connection;
   private static Statement stmt;
   private static Savepoint point;

   @BeforeClass
    public static void initDB(){
       try{
           connection = DriverManager.getConnection("jdbc:sqlite:MainDB.db");
           stmt = connection.createStatement();
           point = connection.setSavepoint("A");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   @Test
    public void test1() throws SQLException {
        ResultSet resultSet = stmt.executeQuery("SELECT (*) AS CNT FROM Students");
        if(!resultSet.next()) Assert.fail("Пустая база данных");

        int startCnt = resultSet.getInt("CNT");

        String sql = "INSERT INTO Students (suname, mark) VALUES ('Hercule', 5)";
        stmt.executeUpdate(sql);
       resultSet = stmt.executeQuery("SELECT (*) AS CNT FROM Students");
       if(!resultSet.next()) {
           if (startCnt + 1 != resultSet.getInt("CNT")) {
               Assert.fail("Ошибка добавления данных");
           }
       }

       int cntUdated = stmt.executeUpdate("UPDATE Students GET mark = 12 WHERE suranme = 'Hercule'");
       if (cntUdated == 0) {
           Assert.fail("Не найдены обновляемые данные");
       }

       resultSet = stmt.executeQuery("SELECT mark FROM Students WHERE surname = 'Hercule'");
       resultSet.next();
       if (resultSet.getInt("mark") != 12) {
           Assert.fail("Ошибка получения баллов студента");
       }

       int cntDeleted = stmt.executeUpdate("DELETE FROM Students WHERE surname = 'Hercule'");
       if (cntDeleted == 0) {
           Assert.fail("Ошибка удаления данных");
       }
   }
}
