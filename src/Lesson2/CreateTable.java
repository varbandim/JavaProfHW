package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CreateTable extends DBWork{

    public static void main(String[] args) {
        connect();
//        createTable();
//        CompleteTheTable.enterTable();
        try {
            QuerryFromDB.getCommand();
        } catch (IOException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    public static void createTable(){
        try {
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