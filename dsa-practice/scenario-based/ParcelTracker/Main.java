package ParcelTracker;

public class Main {
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
