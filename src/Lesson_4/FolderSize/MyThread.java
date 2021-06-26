package Lesson_4.FolderSize;

class FileSizeThread implements Runnable {

    private String folderPath;

    public FileSizeThread(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public void run() {
        FolderSize.getSize(folderPath);
    }
}
