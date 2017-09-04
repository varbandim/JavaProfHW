package Lesson6.Task3;

import java.io.IOException;
import java.sql.SQLException;

public class CreateTable extends DBWork {

    private static final String createCommand = "CREATE TABLE Students(\n" +
            "      id INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "             UNIQUE\n" +
            "             NOT NULL\n," +
            "      surname TEXT,\n" +
            "      mark integer);";
    private static String path = "jdbc:sqlite:src/Lesson6/MainDB.db";

    public static void main(String[] args) {
        DBWork dbWork = new DBWork();
        dbWork.connect(path);
        createTable();
        dbWork.disconnect();
    }

    public static void createTable(){
        try {
            stmt.execute(createCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}