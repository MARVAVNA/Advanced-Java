package Lesson_4;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        ATMBank atmBank1 = new ATMBank(bankAccount);
        ATMBank atmBank2 = new ATMBank(bankAccount);
        ATMBank atmBank3 = new ATMBank(bankAccount);

        OnlineBank onlineBank1 = new OnlineBank(bankAccount);
        OnlineBank onlineBank2 = new OnlineBank(bankAccount);

        atmBank1.start();
        atmBank2.start();
        atmBank3.start();
        onlineBank1.start();
        onlineBank2.start();

        try {
            atmBank1.join();
            atmBank2.join();
            atmBank3.join();
            onlineBank1.join();
            onlineBank2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankAccount.getAmount());

    }
}
