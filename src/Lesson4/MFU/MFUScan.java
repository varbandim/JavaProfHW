package Lesson4.MFU;

/**
 * Created by Admin on 05.09.2017.
 */
public class MFUScan implements Runnable {

    private int numberPage;

    public MFUScan(int numberPage) {
        this.numberPage = numberPage;
    }

    @Override
    public void run() {
        System.out.println("Отсканировано " + numberPage + " раз");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
