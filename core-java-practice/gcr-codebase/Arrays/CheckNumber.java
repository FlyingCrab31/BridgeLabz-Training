import java.util.Scanner;

public class CheckNumber{

public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    int[] number = new int[5]; // Made an array of size 5.
    
    // Now taking inputs from the user.

    for (int i = 0; i < 5; i++) {
        number[i] = sc.nextInt();
    }
    for (int i = 0; i < number.length; i++) {
        if(number[i] < 0) System.out.println("Negative"); // if the no. is neagtive
        else if(number[i] == 0) System.out.println("zero"); // if the number is zero.

//if number is positive , then we'll check for even and odd.

        else{
            System.out.print("positive and ");
            if(number[i] % 2 == 0) System.out.println("even");
            else System.out.println("odd");
        }
    }
    if (number[0] > number[number.length - 1]) {
                System.out.println("First element is greater than last element.");
            } else if (number[0] < number[number.length - 1]) {
                System.out.println("First element is less than last element.");
            } else {
                System.out.println("First and last elements are equal.");
            }
 
}

}