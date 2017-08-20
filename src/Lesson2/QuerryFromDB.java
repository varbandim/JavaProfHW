package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class QuerryFromDB extends DBWork {

    private String whatIsThePrise = "/цена";
    private String toChangeThePrice = "/сменитьцену";
    private String goodsByPrice = "/товарыпоцене";

    private void getCommand() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String command;
        String[] commands = new String[3];
        int
        while (flag) {
            command = r.readLine();
            commands = command.split(" ");
            if (commands[0].equals(whatIsThePrise)) {
                try {
                    String result = stmt.executeQuery("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (commands[0].equals(toChangeThePrice)) {
                try {
                    String result = stmt.executeQuery("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (commands[0].equals(goodsByPrice)) {
                String result = stmt.executeQuery("");
            } else flag = false;
        }
    }

}
