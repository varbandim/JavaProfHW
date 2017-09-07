
package Lesson7;

import org.junit.Test;

public class LearningReflection {
    public static void main(String[] args) {
        Boolean str = true;
        Class stringClass = str.getClass();
        Boolean strValue = str.booleanValue();

        System.out.println(stringClass.getModifiers());
        System.out.println(stringClass.getMethods());
    }
}