package Lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Sequense5Files {
    private static final String path1File = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\1text.txt";
    private static final String path2File = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\2text.txt";
    private static final String path3File = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\3text.txt";
    private static final String path4File = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\4text.txt";
    private static final String path5File = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\5text.txt";
    private static final String pathOutFile = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\outAll.txt";
    public static void main(String[] args) throws Exception{
        ArrayList<FileInputStream> arrFiles = new ArrayList<>();

        long time = System.currentTimeMillis();

        arrFiles.add(new FileInputStream(path1File));
        arrFiles.add(new FileInputStream(path2File));
        arrFiles.add(new FileInputStream(path3File));
        arrFiles.add(new FileInputStream(path4File));
        arrFiles.add(new FileInputStream(path5File));

        SequenceInputStream sec = new SequenceInputStream(Collections.enumeration(arrFiles));

        FileOutputStream out = new FileOutputStream(pathOutFile);
        int b;
        while ((b = sec.read()) != -1) {
            out.write(b);
        }
        sec.close();
        out.close();
        System.out.println("Время выполнения - " + (System.currentTimeMillis() - time));
    }
}
