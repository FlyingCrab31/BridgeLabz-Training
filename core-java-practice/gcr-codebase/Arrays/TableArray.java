import java.util.Scanner;

public class TableArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] table = new int[10]; // Array to store multiplication table.
        System.out.print("Enter a number to print its multiplication table: ");
        int number = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            table[i] = number * (i + 1); // Storing multiplication results in the array.
        }
        System.out.println("Multiplication table of " + number + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " x " + (i + 1) + " = " + table[i]); // Printing the multiplication table.
        }


    }}