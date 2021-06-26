package Lesson_4.FolderSize;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static String folderPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path directoryPath;
        boolean isExit;

        do {
            System.out.print("Please enter the path to the folder: ");
            folderPath = scanner.nextLine();
            isExit = folderPath.equals("exit");
            if (isExit) break;
            directoryPath = Paths.get(folderPath);
        } while (!Files.isDirectory(directoryPath));

        if (isExit) {
            System.out.println("Thank you for using our program!");
        } else {
            Thread thread = new Thread(new FileSizeThread(folderPath));

            thread.start();

            while (thread.isAlive()) {
                try {
                    Thread.sleep(100);
                    double sizeKB = (double) FolderSize.getSize() / 1024;
                    double sizeMB = sizeKB / 1024;
                    System.out.println(FolderSize.getSize() + " bytes, " + String.format("%.2f", sizeKB) + " KB, "
                            + String.format("%.2f", sizeMB) + " MB");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
