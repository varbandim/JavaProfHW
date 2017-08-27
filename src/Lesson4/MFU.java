package Lesson4;

/**
 * Написать класс МФУ, на котором возможны одновременная печать и сканирование
 * документов, при этом нельзя одновременно печатать два документа или сканировать (при
 * печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании
 * тоже​​ самое​​ только​​ "отсканировано...",​​ вывод​​ в​​ консоль​​ все​​ также​​ с​​ периодом​​ в​​ 50​​ мс.)
 */
public class MFU {
//    private Object lock1 = new Object();
//    private Object lock2 = new Object();

    public static void main(String[] args){
        MethodsForMFU m = new MethodsForMFU();
        Thread printThread = new Thread(() -> {
            try {
                m.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread scanThread = new Thread(() -> {
            try {
                m.scan();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        printThread.start();
        scanThread.start();
    }


}
