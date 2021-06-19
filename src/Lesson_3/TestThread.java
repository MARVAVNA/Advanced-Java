package Lesson_3;

public class TestThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> test("T1: "));
        Thread thread1 = new MyThread("T2: ");

        thread.start();
        thread1.start();

        /*try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        System.out.println("Test");
    }

    private static void test(String name) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + i);
            try {
                Thread.interrupted();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(1);
                e.printStackTrace();
            }
        }
    }
}
