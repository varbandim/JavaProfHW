package Lesson6;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Admin on 04.09.2017.
 */
public class Test4OldArray {
    private OldArray oldArray;
    @Test
    public void test1(){
        oldArray = new OldArray();
        Assert.assertArrayEquals(
                new int[]{1, 7}, oldArray.arryAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})
        );
    }
    @Test
    public void test2(){
        oldArray = new OldArray();
        Assert.assertArrayEquals(
                new int[]{1, 7, 8}, oldArray.arryAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 8})
        );
    }
    @Test
    @Ignore
    public void test3(){
        oldArray = new OldArray();
        Assert.assertArrayEquals(
                new int[]{1, 5}, oldArray.arryAfter4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})
        );
    }
    @Test(expected = RuntimeException.class)
    public void test4(){
        oldArray = new OldArray();
        Assert.assertArrayEquals(
                new int[]{1, 7}, oldArray.arryAfter4(new int[]{1, 2, 6, 8, 2, 3, 1, 1, 7})
        );
    }
}
