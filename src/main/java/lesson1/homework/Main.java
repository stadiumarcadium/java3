package lesson1.homework;


import lesson1.test.E;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Задание №1:
        String[] arr1 = {"A", "B", "C"};
        Integer[] arr2 = {1, 2, 3};

        System.out.print("1)\n"
                + Arrays.toString(arr1) + " -> ");
        swapElements(arr1, 0, 2);
        System.out.println(Arrays.toString(arr1));

        System.out.print("\n"
                + Arrays.toString(arr2) + " -> ");
        swapElements(arr2, 0, 2);
        System.out.println(Arrays.toString(arr2) + "\n");

        //Задание №2
        List list = convertToArrayList(arr1);
        System.out.println("2)\n" +
                arr1.getClass().getSimpleName() + " -> " + list.getClass().getSimpleName());

        //Задание №3
        System.out.println("3)\n");
        //создаем коробки:
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();
        //заполняем коробки:
        orangeBox1.add(new Orange());
        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(orangeBox1.getInfo() + ", вес " + orangeBox1.getWeight());
        System.out.println(orangeBox2.getInfo() + ", вес " + orangeBox1.getWeight());
        System.out.println(appleBox.getInfo() + ", вес " + appleBox.getWeight());

        System.out.println("Массы коробок orangeBox1 и appleBox: " + (orangeBox1.compare(appleBox) ? "равны" : "не равны"));
        System.out.println("Масыы коробок orangeBox2 и appleBox: " + (orangeBox2.compare(appleBox) ? "равны" : "не равны"));

        orangeBox1.puInto(orangeBox2);//перекладываем апельсин
        //orangeBox2.puInto(appleBox); в коробке другие фрукты

        System.out.println(orangeBox1.getInfo());
        System.out.println(orangeBox2.getInfo());
        System.out.println(appleBox.getInfo());
}

    //метод меняет два элемента массива местами:
    private static <E> void swapElements(E[] array, int index1, int index2) {
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //метод преобразует массив в ArrayList:
    private static <E> List convertToArrayList(E[] array) {
        return Arrays.asList(array);
    }

}