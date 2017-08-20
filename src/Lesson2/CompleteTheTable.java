package Lesson2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CompleteTheTable extends DBWork{

    public static void enterTable(){
        try {
            stmt.execute("DELETE FROM Goods");
            for (int i = 1; i < 10001; i++) {
                stmt.execute("INSERT INTO Goods (prodId, title, cost) " +
                        "VALUES(" + i + ", 'товар"+ i +" '," + i*10 + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
