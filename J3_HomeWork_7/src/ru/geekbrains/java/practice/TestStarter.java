package ru.geekbrains.java.practice;


import java.lang.reflect.Method;
import java.util.*;

public class TestStarter {

    public static void start(Class cl) throws Exception {
        Method[] methods = cl.getMethods();
        Map<String, Method> suits = getBeforeAndAfter(methods);
        Map<Integer, List<Method>> tests = sortByPriority(methods);

        if (suits.get("BeforeSuite") != null)
            suits.get("BeforeSuite").invoke(null);

        runTests(tests);

        if (suits.get("AfterSuite") != null)
            suits.get("AfterSuite").invoke(null);
    }

    private static Map<String, Method> getBeforeAndAfter(Method[] methods) throws RuntimeException{
        int beforeSuits = 0;
        int afterSuits = 0;
        Map <String, Method> suits = new HashMap<>();
        for (Method method: methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                suits.put("AfterSuite", method);
                afterSuits++;
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                suits.put("BeforeSuite", method);
                beforeSuits++;
            }
        }
        if (beforeSuits > 1) throw new RuntimeException("Too many BeforeSuite statements");
        if (afterSuits > 1) throw new RuntimeException("Too many AfterSuite statements");
        return suits;
    }

    private static Map<Integer, List<Method>> sortByPriority(Method[] methods) {
        Map<Integer, List<Method>> tests = new TreeMap<>();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority > 10) priority = 10;
                else if (priority <= 0) priority = 1;
                if (tests.containsKey(priority))
                    tests.get(priority).add(method);
                else {
                    List<Method> newList = new ArrayList<>();
                    newList.add(method);
                    tests.put(priority, newList);
                }
            }
        }
        return tests;
    }

    private static void runTests(Map<Integer, List<Method>> tests) throws Exception {
        for (int i = 10; i >= 1; i--) {
            if (tests.get(i) != null) {
                for (Method method: tests.get(i)) {
                    if (method != null)
                        method.invoke(null);
                }
            }
        }
    }
}
