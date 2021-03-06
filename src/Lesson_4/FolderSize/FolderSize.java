package Lesson_4.FolderSize;

import java.io.File;
import java.util.Objects;

public class FolderSize {
    private static long size;

    public static void getSize(String path) {

        File file = new File(path);

        if (file.listFiles() == null) {
            return;
        }

        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                getSize(f.getPath());
            } else {
                size += f.length();
            }
        }

    }

    public static long getSize() {
        return size;
    }
}
