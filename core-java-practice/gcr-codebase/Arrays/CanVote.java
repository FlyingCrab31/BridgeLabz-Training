import java.util.Scanner;
 public class CanVote{

    public static void main(String[] args) {
        int[] student = new int[10];
        Scanner sc = new Scanner (System.in);

// initialise an array for students whom to check

        for (int i = 0; i < 10; i++) {
            student[i] = sc.nextInt(); 
        }

        // checking the age of every student if they can vote or not.

        for (int i = 0; i < 10; i++) {
            if(student[i] >= 18){
                System.out.println("The student with the age" +student[i] +"can vote");
                }

            else if(student[i] < 18){
                System.out.println("The student with the age " +student[i] +"cannot vote");
                }

// If the age is in negative then we'll get invalid age as an output...

            else if(student[i]<0) System.out.println("invalid age");
        }

    }

 }