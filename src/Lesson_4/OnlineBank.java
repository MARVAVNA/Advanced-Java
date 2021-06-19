package Lesson_4;

public class OnlineBank extends Thread {

    public BankAccount bankAccount;

    public OnlineBank(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Online Bank transaction started");
        bankAccount.pay(100);
        System.out.println("Online Bank transaction ended");
    }
}
