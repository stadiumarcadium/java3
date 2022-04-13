package lesson4.homework;

public class PrintChar implements Runnable {

    static int i = 1;
    int length = 9;
    static Object lock = new Object();
    int leftOver;

    public PrintChar(int leftOver) {
        this.leftOver = leftOver;
    }

    @Override
    public void run() {
        while (i < length - 1) {

            synchronized (lock) {
                while (i % 3 != leftOver) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(Thread.currentThread().getName());
                i++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintChar r1 = new PrintChar(1);
        PrintChar r2 = new PrintChar(2);
        PrintChar r3 = new PrintChar(0);

        Thread t1 = new Thread(r1, "A");
        Thread t2 = new Thread(r2, "B");
        Thread t3 = new Thread(r3, "C");

        t1.start();
        t2.start();
        t3.start();

    }
}

