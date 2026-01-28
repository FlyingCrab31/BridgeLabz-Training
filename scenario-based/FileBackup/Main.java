package filebackupscheduler;

public class Main {

    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addBackupTask(
                new BackupTask("C:/System", 10));   // Critical
            scheduler.addBackupTask(
                new BackupTask("D:/Projects", 7));
            scheduler.addBackupTask(
                new BackupTask("E:/Movies", 2));

            // Invalid path example
            scheduler.addBackupTask(
                new BackupTask("", 5));

        } catch (InvalidBackupPathException e) {
            System.out.println(" Error: " + e.getMessage());
        }

        scheduler.executeBackups();
    }
}

