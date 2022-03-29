package lesson1.generics;

import lesson1.common.ObjectStorage;

import java.util.Random;

public class GenericTest {
    public static void main(String[] args) {
        GenericStorage<Integer> intStorage = new GenericStorage<>(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);
//        intStorage.add("Hello!");

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValue = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);


        GenericStorage<String> stringStorage = new GenericStorage<>(20);
        stringStorage.add("A");
        stringStorage.add("B");
        stringStorage.add("C");
        stringStorage.add("D");
        stringStorage.add("E");
//        stringStorage.add(new Random());

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("D"));
        System.out.println("Find 5: " + stringStorage.find("X"));

        String lastValueString = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value String: " + lastValueString);

/*        GenericStorage<Random> randomGenericStorage = new GenericStorage<>();
        randomGenericStorage.add(new Random());
        randomGenericStorage.add(new Random());
        randomGenericStorage.add(new Random());*/


    }
}
