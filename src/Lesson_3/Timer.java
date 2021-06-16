package Lesson_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        int minutes = timer.getNumber(0, 60, "Please enter the number of minutes: ");
        int seconds = timer.getNumber(0, 60, "Please enter the number of seconds: ");

        int allSeconds = 60 * minutes + seconds;

        secondTimer(minutes, seconds);
        if (allSeconds > 0) {
            for (int i = allSeconds; i > 0; i--) {
                if (i % 60 == 0) {
                    seconds = 59;
                    minutes--;
                } else {
                    seconds--;
                }

                secondTimer(minutes, seconds);
            }
        }
    }

    private static void secondTimer(int minutes, int seconds) {
        System.out.println(new StringBuilder()
                .append(minutes < 10 ? "0" + minutes : minutes)
                .append(":")
                .append(seconds < 10 ? "0" + seconds : seconds)
                .toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getNumber(int min, int max, String text) {
        Scanner scanner = new Scanner(System.in);
        int input = min - 1;
        boolean isNumber = true;
        while (input < min || input > max) {
            try {
                if (!isNumber) {
                    scanner.next();
                }
                System.out.print(text);
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                isNumber = false;
                System.out.println("You entered not a number");
            }
        }

        return input;
    }
}
