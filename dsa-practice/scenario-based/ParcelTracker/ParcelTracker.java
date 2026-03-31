package ParcelTracker;

public class ParcelTracker {

    private ParcelStage head;

    public ParcelTracker() {
        this.head = null;
    }

    // Add a new stage at the end of the tracking chain
    public void addStage(String stageName) {
        ParcelStage newStage = new ParcelStage(stageName);
        if (head == null) {
            head = newStage;
        } else {
            ParcelStage current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStage;
        }
    }

    // Insert a custom checkpoint after a specified stage
    public void insertCheckpoint(String afterStage, String checkpointName) {
        ParcelStage current = head;
        while (current != null && !current.stageName.equals(afterStage)) {
            current = current.next;
        }
        if (current != null) {
            ParcelStage checkpoint = new ParcelStage(checkpointName);
            checkpoint.next = current.next;
            current.next = checkpoint;
        } else {
            System.out.println("Stage " + afterStage + " not found.");
        }
    }

    // Track the parcel through its stages
    public void trackParcel() {
        if (head == null) {
            System.out.println("No stages available. Parcel might be lost.");
            return;
        }
        ParcelStage current = head;
        while (current != null) {
            System.out.println("Current Stage: " + current.stageName);
            current = current.next;
        }
    }

}
