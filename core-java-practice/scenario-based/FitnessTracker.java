import java.util.Scanner;

public class FitnessTracker{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Stores the count of pushups for a week...
        //Use continue to skip rest days.
        int[] pushUpsPerDay = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter push-ups for day " + (i + 1) + " (enter 0 for rest day): ");
            int pushUps = sc.nextInt();
            if (pushUps == 0) {
                continue; // Skip rest days
            }
            pushUpsPerDay[i] = pushUps;
        }
        // Calculate total push-ups using for-each loop
        int totalPushUps = 0;
        for (int pushUps : pushUpsPerDay) {
            totalPushUps += pushUps;
        }
        System.out.println("Total push-ups in the week: " + totalPushUps);
        
        //Use for-each to calculate total and average.
        double averagePushUps = totalPushUps / 7.0;
        System.out.println("Average push-ups per day: " + averagePushUps);


        
}}