package Lesson4;

/**
 * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз, порядок
 * должен​​ быть​​ именно​​ ABСABСABС.​​ Используйте​​ wait/notify/notifyAll.
 */
public class ThreeThreads {
    public static void main(String[] args) throws InterruptedException {
        PrintChar printChar = new PrintChar();
        Thread t1 = new Thread(() -> {
            printChar.printLetterA();
        });
        Thread t2 = new Thread(() -> {
            printChar.printLetterB();
        });
        Thread t3 = new Thread(() -> {
            printChar.printLetterC();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
