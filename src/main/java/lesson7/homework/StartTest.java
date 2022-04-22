package lesson7.homework;

public class StartTest {
    public static void main(String[] args) {
        TestCase testCase = new TestCase();
        Tester.start(testCase.getClass());
    }
}
