package Lesson7.HomeWork;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void start(Class<?> className) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        Map<Integer, Method> map = new TreeMap<>();
        int countBefore = 0;
        int countAfter = 0;

        for(Method method: className.getDeclaredMethods()){
            if (method.getAnnotation(BeforeSuite.class) != null){
                map.put(MIN_PRIORITY -1, method);
                countBefore++;
            }
            if (method.getAnnotation(AfterSuite.class) != null){
                map.put(MAX_PRIORITY + 1, method);
                countAfter++;
            }
            if (method.getAnnotation(Test.class) != null){
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
            if (countBefore > 1) throw new RuntimeException("Несколько тестов с аннотацией BeforeSuite");
            if (countAfter > 1) throw new RuntimeException("Несколько тестов с аннотацией AfterSuite");
        }

        System.out.println("Map " + className.getSimpleName() + ":");
        for (Integer key :
                map.keySet()) {
            System.out.println("Приоритет: " + key + " для метода " + map.get(key).getName());
        }
        System.out.println();
        System.out.println("Reflections " + className.getSimpleName() + ":");
        try{
        TestCase testCase = new TestCase();
        for (Integer key :
                map.keySet()) {
            map.get(key).invoke(testCase);
        }
        } catch(IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Аннотации: ");
        start(TestCase.class);
    }
}
