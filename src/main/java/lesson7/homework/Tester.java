package lesson7.homework;

import java.lang.reflect.*;
import java.util.*;


public class Tester {
    public static void start(Class<?> className) {

        if (!annotationsCorrect(className)) {
            throw new RuntimeException();
        }

        //сортировка по преоритету:
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        Map<Integer, Method> map = new TreeMap<>();

        for (Method method : className.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                map.put(MIN_PRIORITY - 1, method);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                map.put(MAX_PRIORITY + 1, method);
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
        }

        System.out.println("Reflections for " + className.getSimpleName() + ":");
        try {
            Object testCase = className.newInstance();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(testCase);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static boolean annotationsCorrect(Class<?> className) {
        int beforeCount = 0;
        int afterCount = 0;

        for (Method method : className.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeCount++;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterCount++;
            }
        }

        return (beforeCount < 2) && (afterCount < 2);
    }
}

