package Lesson4;
import java.io.*;
/**
 * Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук
 * по​​ 10​​ записей,​​ с​​ периодом​​ в​​ 20​​ мс)
 */
public class WriteLog {
    public final static String pathFile = "D:\\!YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson4\\log.txt";
    public static BufferedWriter writer;
    public static void main(String[] args) throws IOException {
        writer = new BufferedWriter(new FileWriter(pathFile));
        new Thread(new writToFile(writer)).start();
        new Thread(new writToFile(writer)).start();
        new Thread(new writToFile(writer)).start();
    }
    public static class writToFile implements  Runnable {
        private BufferedWriter writer;
        public writToFile(BufferedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                try {
                    writer.write(i + " строка: " + Thread.currentThread().getName() + "\n");
                    Thread.sleep(20);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}