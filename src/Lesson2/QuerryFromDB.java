package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuerryFromDB extends DBWork {

    private static final String whatIsThePrise = "/цена";
    private static final String toChangeThePrice = "/сменитьцену";
    private static final String goodsByPrice = "/товарыпоцене";

    public static void getCommand() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String command;
        String[] commands = new String[3];

        while (flag) {
            command = r.readLine();
            commands = command.split(" ");
            if (commands[0].equals(whatIsThePrise)) {
                //получение цены по названию товара
                try {
                    ResultSet result = stmt.executeQuery("SELECT * FROM Goods WHERE title = '" +
                            commands[1] + "'");
                    if (!result.next()) System.out.println("Такого товара нет");
                    else System.out.println(result.getInt("id") + " " +
                            result.getInt("prodID") + " " +
                            result.getString("title") + " " +
                            result.getDouble("cost"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //замена цены товара на другую
            } else if (commands[0].equals(toChangeThePrice)) {
                try {
                    stmt.execute(
                            "UPDATE Goods " +
                                    "SET cost = " + commands[2] +
                                    " WHERE title = '" + commands[1] + "'");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //вывод товаров в диапазоне цен
            } else if (commands[0].equals(goodsByPrice)) {
                try {
                    ResultSet result = stmt.executeQuery("SELECT * FROM Goods WHERE (cost > " +
                            commands[1] + " AND cost < " + commands[2] + ")");
                    while(result.next()) {
                        System.out.println(result.getInt("id") + " " +
                                result.getInt("prodID") + " " +
                                result.getString("title") + " " +
                                result.getDouble("cost"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if ((commands[0].equals("/exit") || (commands[0].equals("/выход")))) break;
            else break;
        }
        r.close();
    }

}
