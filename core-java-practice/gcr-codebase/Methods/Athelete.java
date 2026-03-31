import java.util.Scanner;

public class Athelete{

    // Method to calculate complete rounds by using perimeter and distance.
    private static int completeRounds(int x , int y , int z , int distance){    
        int perimeter = x + y + z;
        int rounds = distance / perimeter;
        return rounds;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int distance = sc.nextInt();
        System.out.println(completeRounds(x, y, z, distance));
    }



}