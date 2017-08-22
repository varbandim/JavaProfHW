package Lesson2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CompleteTheTable extends DBWork{
    private final static String insCommand =  "INSERT INTO Goods (prodId, title, cost) VALUES(";

    public static void enterTable(){
        try {
            stmt.execute("DELETE FROM Goods");
            for (int i = 0; i < 100; i++) {
                stmt.execute( insCommand + i + ", 'товар"+ i +"'," + i*10 + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
