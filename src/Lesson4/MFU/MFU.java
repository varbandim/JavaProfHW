package Lesson4.MFU;

/**
 * Написать класс МФУ, на котором возможны одновременная печать и сканирование
 * документов, при этом нельзя одновременно печатать два документа или сканировать (при
 * печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании
 * тоже​​ самое​​ только​​ "отсканировано...",​​ вывод​​ в​​ консоль​​ все​​ также​​ с​​ периодом​​ в​​ 50​​ мс.)
 * <p>
 * монитор по принтеру и монитор по сканеру
 */
public class MFU {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        synchronized (lock1) {
            for (int i = 0; i < 1000; i++) {
                new Thread(new MFUPrint(i)).start();
                new Thread(new MFUScan(i)).start();
            }
        }
//        synchronized (lock2) {
//            for (int i = 0; i < 1000; i++) {
//
//            }
//        }
    }


}
