import java.util.Scanner;

public class FactorArray{
    // Method to generate factors of a number and return them as an array
    private static int[] generateFactors(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to calculate sum of all the factors..

    private static int sumOfFactors(int[] factors){
        int sum = 0;
        for(int factor : factors){
            sum += factor;
        }
        return sum;
    }
    // Method to find sum of square of factors..

    private static int sumOfSquareOfFactors(int[] factors){
        int sum = 0;
        for(int factor : factors){
            sum += factor * factor;
        }
        return sum;
    }

    // Method to find product of the factors..

    private static int productOfFactors(int[] factors){
        int product = 1;
        for(int factor : factors){
            product *= factor;
        }
        return product;
    } 
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] factors = generateFactors(number);
        System.out.print("Factors: ");
        for(int factor : factors){
            System.out.print(factor + " ");
        }
        System.out.println();

        System.out.println("Sum of Factors: " + sumOfFactors(factors));
        System.out.println("Sum of Square of Factors: " + sumOfSquareOfFactors(factors));
        System.out.println("Product of Factors: " + productOfFactors(factors));
    } 
}