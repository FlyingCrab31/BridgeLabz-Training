import java.util.Scanner;

public class ChocolateDistribution{

    // method to find the number of chocolates each child gets and number of remaining chocolates
    private static int[] distributeChocolates(int chocolates, int children){
        int chocolatesPerChild = chocolates / children;
        int remainingChocolates = chocolates % children;
        return new int[]{chocolatesPerChild, remainingChocolates};
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chocolates = sc.nextInt();
        int children = sc.nextInt();

        int[] result = distributeChocolates(chocolates, children);
        System.out.println("Chocolates per child: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);
    }
}