package Lesson4;

public class PrintChar {
    private volatile String letter = "A";
    private final Object mon = new Object();

//    public PrintChar(String letter) {
//        this.letter = letter;
//    }

    public void printLetterA(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("A")){
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = "B";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printLetterB(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("B")){
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = "C";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printLetterC(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("C")){
                        mon.wait();
                    }
                    System.out.println(letter);
                    letter = "A";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}