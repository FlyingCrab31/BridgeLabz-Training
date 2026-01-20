
class ParcelStage {

    String stageName;
    ParcelStage next;

    ParcelStage(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }

}

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

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        System.out.println("Tracking parcel:");
        tracker.trackParcel();

        System.out.println("\nInserting a checkpoint after 'Shipped':");
        tracker.insertCheckpoint("Shipped", "Custom Checkpoint 1");
        tracker.trackParcel();

        System.out.println("\nAttempting to insert a checkpoint after a non-existent stage:");
        tracker.insertCheckpoint("NonExistentStage", "Custom Checkpoint 2");
    }
}
