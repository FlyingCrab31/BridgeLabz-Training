import java.util.Scanner;

class FriendAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Create arrays for ages and heights of 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        // a. Take user input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            
            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = sc.nextDouble();
        }
        
        // b. Find youngest (minimum age) and tallest (maximum height)
        int minAgeIndex = 0;
        int maxHeightIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        
        // c. Display results
        System.out.println(" RESULT ");
        System.out.println("Youngest Friend: " + names[minAgeIndex] + 
                          " (Age: " + ages[minAgeIndex] + " years)");
        System.out.println("Tallest Friend: " + names[maxHeightIndex] + 
                          " (Height: " + heights[maxHeightIndex] + " cm)");
        
        sc.close();
    }
}