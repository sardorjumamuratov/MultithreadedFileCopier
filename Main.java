
public class Main {
    public static void main(String[] args) {
        MetaInfo metaInfo = new MetaInfo();
        ProgressBar progressBar = new ProgressBar(metaInfo);
        FileCopier fileCopier = new FileCopier(metaInfo);

        Thread progressBarThread = new Thread(progressBar);
        Thread fileCopierThread = new Thread(fileCopier);
        progressBarThread.start();
        fileCopierThread.start();
    }
}
