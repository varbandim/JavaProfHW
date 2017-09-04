package Lesson6.Task1;

public class OldArray {
    public void floo () {
        int[] oldArr = {1, 2, 2, 5, 4, 3, 5, 1, 7};
        int[] newArr = arryAfter4(oldArr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    public int[] arryAfter4(int[] oldArr) {
        int index = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] == 4) {
                index = i;
            }
        }
        if (index == 0) throw new RuntimeException();
        index++;
        int[] newArr = new int[oldArr.length - index];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = oldArr[index];
            index++;
        }
        return newArr;
    }
}
class Example{
    public static void main(String[] args) {
        new OldArray().floo();
    }
        }