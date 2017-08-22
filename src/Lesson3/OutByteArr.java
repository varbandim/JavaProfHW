package Lesson3;

import java.io.*;
import java.util.Timer;

public class OutByteArr {

    private static final String passToFile = "D:/!YandexDisk/geekbrains.ru/Java. Prof/HomeWorks/src/Lesson3/50byte.txt";

    public static void main(String[] args) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        long time = System.currentTimeMillis();

        in = new BufferedInputStream(new FileInputStream(passToFile));
        out = new ByteArrayOutputStream();
        int data = 0;
        while ((data = in.read()) != -1) {
            out.write(data);
        }
            byte[] arr = out.toByteArray();
            for (byte b:
                 arr) {
                System.out.println(b);
            }

        in.close();
        System.out.println("Время выполнения - " + (System.currentTimeMillis() - time));
    }
}
