package lesson6.homework;

import java.util.Arrays;

public class Shift {

    public static void main(String[] args) {
        shiftArray(new int[] {1, 2, 3, 4, 5}, 0);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 1); // 5 1 2 3 4
        shiftArray(new int[] {1, 2, 3, 4, 5}, 2); // 4 5 1 2 3
        shiftArray(new int[] {1, 2, 3, 4, 5}, 5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, 6);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -1); // 2 3 4 5 1
        shiftArray(new int[] {1, 2, 3, 4, 5}, -2); // 3 4 5 1 2
        shiftArray(new int[] {1, 2, 3, 4, 5}, -5);
        shiftArray(new int[] {1, 2, 3, 4, 5}, -6);
    }

    // 1 2 3 -> 3 1 2
    public static String shiftArray(int[] array, int n) {
        int shiftNumber = n % array.length;
        if (shiftNumber < 0) {
            shiftLeft(array, Math.abs(shiftNumber));
        }
        else {
            shiftRight(array, shiftNumber);
        }
        System.out.println(Arrays.toString(array) + "; shiftNumber = " + n);
        return Arrays.toString(array);
    }

    private static void shiftRight(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int lastValue = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = lastValue;
        }
    }

    // 1 2 3 -> 2 3 1
    // 2 2 3
    // 2 3 3
    // 2 3 1
    private static void shiftLeft(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int firstValue = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstValue;
        }
    }
}
