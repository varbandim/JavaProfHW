package Lesson4.MFU;

import static Lesson4.MFU.Device.lock1;

/**
 * Написать класс МФУ, на котором возможны одновременная печать и сканирование
 * документов, при этом нельзя одновременно печатать два документа или сканировать (при
 * печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании
 * тоже​​ самое​​ только​​ "отсканировано...",​​ вывод​​ в​​ консоль​​ все​​ также​​ с​​ периодом​​ в​​ 50​​ мс.)
 * <p>
 * монитор по принтеру и монитор по сканеру
 */
public class MFU {


    public static void main(String[] args) {

        Device mfu = new Device();
        for (int i = 0; i < 10; i++) {
            int f = i;
            new Thread(() -> mfu.mfuPrint(f, 10)).start();
            new Thread(() -> mfu.mfuScan(f, 10)).start();

        }

    }
}
    class Device {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    void mfuPrint(int i, int n) {
        synchronized (lock1) {
            System.out.println();
            System.out.println("Печать в потоке" + i);
            System.out.println("*****************************");
            for (int j = 0; j < n; j++) {
                System.out.println("Отпечатано " + j +" страницы в " + i + " потоке");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("*****************************");
        }
    }

    void mfuScan(int i, int n) {
        synchronized (lock2) {
            System.out.println();
            System.out.println("Сканирование в потоке " + i);
            System.out.println("*****************************");
            for (int j = 0; j < n; j++) {
                System.out.println("Отсканировано " + j + " страниц в " + i + " потоке");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("*****************************");
        }
    }
}