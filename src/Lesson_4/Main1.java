package Lesson_4;

public class Main1 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread("T1", counter);
        MyThread t2 = new MyThread("T2", counter);
        MyThread t3 = new MyThread("T3", counter);

        t1.start();
        t2.start();
        t3.start();
    }
}
