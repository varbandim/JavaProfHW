package Lesson4.MFU;

/**
 * синхронизировать внутри вспомогательных классов, потому что
 * надо блочить выполнение каждого.
 */
public class MFUPrint implements Runnable{
    private int numberPage;

    public MFUPrint(int numberPage) {
        this.numberPage = numberPage;
    }

    @Override
    public void run() {

    }
}
