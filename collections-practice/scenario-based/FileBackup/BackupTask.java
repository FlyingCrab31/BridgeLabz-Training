package filebackupscheduler;

public class BackupTask implements Comparable<BackupTask> {

    private String folderPath;
    private int priority; // Higher value = higher priority

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Backup path is invalid!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    // Higher priority tasks should be executed first
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }

    public void executeBackup() {
        System.out.println("  Backing up folder: " + folderPath
                + " | Priority: " + priority);
    }
}
