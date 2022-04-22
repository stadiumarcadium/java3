package lesson7.homework;

public class TestCase {
    @BeforeSuite
    public void before() {
        System.out.println("Before");
    }

    @AfterSuite
    public void after() {
        System.out.println("After");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("Test1 priority 1");
    }

    @Test(priority = 7)
    public void methodTest2() {
        System.out.println("Test2 priority 7");
    }

    @Test(priority = 3)
    public void methodTest3() {
        System.out.println("Test3 priority 4");
    }

}
