package Lesson_4;

public class MyThread extends Thread {
    private String name;
    private Counter counter;

    public MyThread(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count(name);
    }
}
