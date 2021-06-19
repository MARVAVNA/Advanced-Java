package Lesson_4;

public class ATMBank extends Thread {

    public BankAccount bankAccount;

    public ATMBank(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("ATM transaction started");
        bankAccount.pay(100);
        System.out.println("ATM transaction ended");
    }
}
