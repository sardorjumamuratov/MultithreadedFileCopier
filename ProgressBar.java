import java.util.concurrent.atomic.AtomicInteger;

public class ProgressBar implements Runnable {
    private final MetaInfo metaInfo;

    public ProgressBar(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    @Override
    public void run() {
        AtomicInteger progress = metaInfo.getProgress();
        while (progress.get() < 100) {
            System.out.println("The progress is now " + progress.get() + "%");
            System.out.println("Copiedfiles => " + metaInfo.getCopiedFiles());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            progress = metaInfo.getProgress();
        }
    }
}
