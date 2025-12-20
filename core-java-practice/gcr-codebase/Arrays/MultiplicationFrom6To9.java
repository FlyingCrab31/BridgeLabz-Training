import java.util.Scanner;

public class MultiplicationFrom6To9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int[] multiplicationTable = new int[10];
        for (int i = 0; i < 10; i++) {
            multiplicationTable[i] = num * (i + 1);
        }
        System.out.println("Multiplication table of " + num + " from 6 to 9:");
        for (int i = 0; i < 10; i++) {
            System.out.println(num + " x " + (i + 1) + " = " + multiplicationTable[i]);
            
        }
        
    }
        
}