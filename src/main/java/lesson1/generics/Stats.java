package lesson1.generics;


public class Stats<E extends Number> {
    private E[] nums;

    public static void main(String[] args) {
        Stats<Integer> integerStats = new Stats<>(1, 2, 3, 4, 5);
        Stats<Double> doubleStats = new Stats<>(1.2, 2.3, 4.5, 2.4);

        System.out.println("sum ints: " + integerStats.sum());
        System.out.println("sum doubles: " + doubleStats.sum());

        System.out.println("sum vs sum: " + integerStats.isSumEquals(doubleStats));
    }

    private boolean isSumEquals(Stats<?> stats) {
        return Math.abs(stats.sum() - sum())  < 0.0000001;
    }

    public Stats(E... nums) {
        this.nums = nums;
    }

    public double sum() {
        double sum = 0;
        for (E num : nums) {
            sum += num.doubleValue();
        }

        return sum;
    }

}

