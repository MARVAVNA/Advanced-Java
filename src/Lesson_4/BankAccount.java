package Lesson_4;

public class BankAccount extends Thread {

    private int amount;

    public int getAmount() {
        return amount;
    }

    public BankAccount(int amount) {
        this.amount = amount;
    }

    public synchronized void pay(int money) {
        int newBalance = amount - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amount = newBalance;
    }
}

