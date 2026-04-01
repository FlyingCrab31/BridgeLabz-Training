package filebackupscheduler;

import java.util.PriorityQueue;

public class BackupScheduler {

    private PriorityQueue<BackupTask> backupQueue;

    public BackupScheduler() {
        backupQueue = new PriorityQueue<>();
    }

    public void addBackupTask(BackupTask task) {
        backupQueue.offer(task);
    }

    public void executeBackups() {
        System.out.println("\n Executing Backup Tasks...\n");

        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            task.executeBackup();
        }
    }
}
