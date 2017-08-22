package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CreateTable extends DBWork{

    private static final String createCommand = "CREATE TABLE Goods(\n" +
            "      id INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "             UNIQUE\n" +
            "             NOT NULL\n," +
            "      prodID INTEGER,\n" +
            "      title TEXT,\n" +
            "      cost REAL);";

    public static void main(String[] args) {
        connect();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTable();
        CompleteTheTable.enterTable();
        try {
            QuerryFromDB.getCommand();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    public static void createTable(){
        try {
            stmt.execute(createCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}