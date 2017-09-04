package Lesson6.Task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//public class TestWait4And1 {
//    private WaitFor4And1 wait;
//
//    @Test
//    public void TestWait4And1(){
//        wait = new WaitFor4And1();
//        Assert.assertFalse(wait.wait(new int[]{5, 6, 7, 8, 1, 2,}));
//    }

    @RunWith(Parameterized.class)
    public class TestWait4And1 {
        private WaitFor4And1 wait;
        private int[] b;

        public TestWait4And1(int[] b) {
            this.b = b;
        }

        @Parameterized.Parameters
        public Collection<Object[]> data(){
            return Arrays.asList(new Object[][]{
                    {new int[]{1,2,3,4}},
                    {new int[]{1,4,4,1,4,1}},
                    {new int[]{5,2,6,8,1,4,5}},
                    {new int[]{1,4,4}}
            });


        }
        @Before
        public void init(){
            wait = new WaitFor4And1();
        }
        @Test
        public void test1(){
            Assert.assertFalse(wait.wait(b));
        }
    }
//}
