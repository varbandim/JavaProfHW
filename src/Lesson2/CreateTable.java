package Lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends DBWork{

    public static void main(String[] args) {
        connect();
        createTable();
        CompleteTheTable.enterTable();

        disconnect();
    }

    public static void createTable(){
        try {
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE Goods(\n" +
                    "      id INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                    "             UNIQUE\n" +
                    "             NOT NULL\n," +
                    "      prodID INTEGER,\n" +
                    "      title TEXT,\n" +
                    "      cost REAL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}