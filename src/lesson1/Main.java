package lesson1;

import java.util.ArrayList;

public class Main {
    /*
      Написать метод, который меняет два элемента массива местами.
      (массив может быть любого ссылочного типа) (дженерик метод, не класс);
     */
    public static <T> void changeTwoElements(T[] t, int index1, int index2) {
        T temp = t[index1];
        t[index1] = t[index2];
        t[index2] = temp;
    }

    /*Написать метод, который преобразует массив в ArrayList (дженерик метод, не класс);*/
    public static <T> ArrayList<T> outArr(T[] t) {
        ArrayList<T> arr = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            arr.add(t[i]);
        }
        return arr;
    }
}