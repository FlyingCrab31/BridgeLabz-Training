public class FactorProgram {
    
    // Method to find factors of a number and return as array
    public static int[] findFactors(int number) {
        // First loop: count the number of factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        // Create array with exact size
        int[] factors = new int[count];
        
        // Second loop: find and store factors in array
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        
        return factors;
    }
    
    // Method to find greatest factor using factors array
    public static int findGreatestFactor(int[] factors) {
        if (factors.length >= 2) {
            return factors[factors.length - 2]; // Second last is greatest proper factor
        }
        return 1;
    }
    
    // Method to find sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }
    
    // Method to find product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }
    
    // Method to find product of cube of factors
    public static double productOfCubeFactors(int[] factors) {
        double product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= Math.pow(factors[i], 3);
        }
        return product;
    }
    
    public static void main(String[] args) {
        int number = 24;
        
        // Find factors
        int[] factors = findFactors(number);
        
        System.out.println("Number: " + number);
        System.out.print("Factors: ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        
        System.out.println("Greatest proper factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Product of cube of factors: " + productOfCubeFactors(factors));
    }
}
