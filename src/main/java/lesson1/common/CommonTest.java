package lesson1.common;

import java.util.Random;

public class CommonTest {

    public static void main(String[] args) {
        intTest();
        stringTest();
        objTest();
    }

    private static void intTest() {
        IntStorage intStorage = new IntStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValue = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);
    }

    private static void stringTest() {
        StringStorage stringStorage = new StringStorage(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
        stringStorage.add("D");
        stringStorage.add("E");

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("D"));
        System.out.println("Find 5: " + stringStorage.find("X"));

        String lastValue = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);
    }

    private static void objTest() {
        ObjectStorage intStorage = new ObjectStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);
        intStorage.add("Hello!");

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValue = (int)intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);


        ObjectStorage stringStorage = new ObjectStorage(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
        stringStorage.add("D");
        stringStorage.add("E");
        stringStorage.add(new Random());


        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("D"));
        System.out.println("Find 5: " + stringStorage.find("X"));

        String lastValueString = (String)stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value String: " + lastValueString);
    }


}
