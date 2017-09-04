package Lesson6.Task2;

public class WaitFor4And1 {

    public boolean wait (int[] arr){
        boolean flag1 = false;
        boolean flag4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) flag1 = true;
            if (arr[i] == 4) flag4 = true;
        }
        return flag1 || flag4;
    }
}