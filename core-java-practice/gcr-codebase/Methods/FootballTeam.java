import java.util.Random;

public class FootballTeam {
    
    // Method to generate random heights for 11 players (150-250 cms)
    public int[] generateHeights() {
        Random rand = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }
        return heights;
    }
    
    // Method to find sum of all elements in array
    public int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    // Method to find mean height
    public double findMean(int[] heights) {
        int sum = sumArray(heights);
        return (double) sum / heights.length;
    }
    
    // Method to find shortest height
    public int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }
    
    // Method to find tallest height
    public int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }
    
    public static void main(String[] args) {
        FootballTeam team = new FootballTeam();
        int[] heights = team.generateHeights();
        
        System.out.println("Player Heights:");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cms");
        }
        
        System.out.println("\nResults:");
        System.out.println("Shortest height: " + team.findShortest(heights) + " cms");
        System.out.println("Tallest height: " + team.findTallest(heights) + " cms");
        System.out.println("Mean height: " + team.findMean(heights) + " cms");
    }
}
