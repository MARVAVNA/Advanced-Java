package Lesson_4.FileSize;

class FileSizeThread implements Runnable {

    private String folderPath;

    public FileSizeThread(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public void run() {
        FileSize.getSize(folderPath);
    }
}
