import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class MetaInfo {
    private AtomicInteger progress;
    private Set<String> copiedFiles;

    public MetaInfo() {
        progress = new AtomicInteger(0);
        copiedFiles = new HashSet<>();
    }

    public void setProgress(AtomicInteger progress) {
        this.progress = progress;
    }

    public AtomicInteger getProgress() {
        return progress;
    }

    public void addCopiedFileName(String name) {
        copiedFiles.add(name);
    }

    public Set<String> getCopiedFiles() {
        return copiedFiles;
    }
}
