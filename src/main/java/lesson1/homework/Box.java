package lesson1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits;

    public Box(T... Fruit) {
        fruits = Arrays.asList(Fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }

    public Box() {
        fruits = new ArrayList<T>();
    }

    void add(T Fruit) {
        fruits.add(Fruit);
    }

    void puInto(Box<T> box) {
        box.getFruits().addAll(fruits);
        fruits.clear();
    }

    String getInfo() {
        return (fruits.isEmpty()) ?
                "Пустая коробка" :
                "Коробка: " + fruits.get(0).toString() + " " + fruits.size() + " Шт.";
    }

    float getWeight() {
        return fruits.isEmpty() ? 0 : fruits.size() * fruits.get(0).getWeight();
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
}
