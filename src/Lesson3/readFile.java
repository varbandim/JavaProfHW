package Lesson3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class readFile {

//    private static final String passFile = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\10Mb.txt";
    private static final String pathFile = "C:\\Users\\Sim\\YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson3\\10Mb.txt";

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Одна страница ~ 1800 символов. Введите номер страницы для чтения: ");
        int page = Integer.parseInt(r.readLine());
        if (page > 1) page = page*1800;//установка указателя на нужную строку
        if (page < 1) page = Math.abs(page);//чтобы не баловались
        System.out.println(new String(readCharsFromFile(pathFile, page)));

        r.close();
    }

    //метод для чтения из заданного места файла
    private static byte[] readCharsFromFile(String pathFile, int page) throws Exception {
        RandomAccessFile file = new RandomAccessFile(pathFile, "r");
        file.seek(page);
        byte[] bytes = new byte[3600];//размер буфера чтения. Если попадает в середину символа - я не виноват. Как обойти - не нашёл.
        file.read(bytes);
        file.close();
        return bytes;
    }

}
