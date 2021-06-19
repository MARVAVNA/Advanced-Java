package Lesson_4;

public class Counter {

    private boolean isFirst = true;
    private boolean isSecond = false;
    private boolean isThird = false;
    public synchronized void count(String name) {
        for (int i = 1; i < 11; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isFirst && !isSecond && i == 5) {
                isFirst = false;
                isSecond = true;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!isFirst && isSecond && i == 6) {
                isSecond = false;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!isFirst && !isSecond && !isThird && i == 10) {
                isThird = true;
                notifyAll();
            }
        }
    }

}
