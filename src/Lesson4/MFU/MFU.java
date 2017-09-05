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
            int finalI = i;
            new Thread(() -> mfu.mfuPrint(finalI)).start();
            new Thread(() -> mfu.mfuScan(finalI)).start();

        }

    }
}
    class Device {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    void mfuPrint(int i) {
        synchronized (lock1) {
            System.out.println("Отпечатано " + i + " раз");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void mfuScan(int i) {
        synchronized (lock2) {
            System.out.println("Отсканировано " + i + " раз");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}