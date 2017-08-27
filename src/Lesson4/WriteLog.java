package Lesson4;

import java.io.*;

/**
 * Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук
 * по​​ 10​​ записей,​​ с​​ периодом​​ в​​ 20​​ мс)
 *
 * including ThreadForWriteFile.java
 */
public class WriteLog {
    public final static String pathFile = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson4\\log.txt";
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter(pathFile));
        ThreadForWriteFile threadForWriteFile = new ThreadForWriteFile();

        Thread t1 = new Thread(() ->{
            threadForWriteFile.getName();
        });
        Thread t2 = new Thread(() ->{
            threadForWriteFile.getName();
        });
        Thread t3 = new Thread(() ->{
            threadForWriteFile.getName();
        });

        w.write(String.valueOf(t1));
        w.write("\n");
        w.write(String.valueOf(t2));
        w.write("\n");
        w.write(String.valueOf(t3));
        w.close();
    }
}