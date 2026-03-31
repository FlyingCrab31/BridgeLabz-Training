// Program to find the mean height of players in a football team
import java.util.Scanner;

public class HeightOfPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a double array named heights of size 11
        double[] heights = new double[11];

        System.out.println("Enter the heights of 11 players (in feet):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
        }

        // Find the sum of all the elements present in the array
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Divide the sum by 11 to find the mean height
        double meanHeight = sum / heights.length;

        System.out.println("\nTotal sum of heights: " + sum);
        System.out.println("Mean height of the football team: " + meanHeight);

        sc.close();
    }
}
