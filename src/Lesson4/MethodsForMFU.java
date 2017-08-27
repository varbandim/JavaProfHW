package Lesson4;

/**
 * Created by User on 27.08.2017.
 */
public class MethodsForMFU {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void print() throws InterruptedException {
        for (int i = 0; i < 100; ++i) {
            System.out.println("отпечатано " + i + " страницы");
            Thread.sleep(50);
        }
    }

    public void scan() throws InterruptedException {
        for (int i = 0; i < 100; ++i) {
            System.out.println("отсканировано " + i + " страницы");
            Thread.sleep(50);
        }
    }

//    private boolean flag = true;
//
//    public synchronized void print() throws InterruptedException {
//
//        int count = 0;
//        while (count < 100) {
//            while (!flag) {
//                wait();
//            }
//            count++;
//            System.out.println("отпечатано " + count + " страницы");
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            flag = false;
//            notify();
//        }
//    }
//
//
//    public synchronized void scan() throws InterruptedException {
//
//        int count = 0;
//        while (count < 100) {
//            while (flag) {
//                wait();
//            }
//            count++;
//            System.out.println("отсканировано " + count + " страницы");
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            flag = true;
//            notify();
//        }
//    }
//
}
