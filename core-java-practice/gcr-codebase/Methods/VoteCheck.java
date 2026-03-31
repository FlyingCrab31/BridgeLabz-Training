import java.util.Scanner;

public class VoteCheck{
    public boolean canStudentVote(int age){
        return age >= 18;
    }
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Student = new int[10];
        for(int i = 0; i < 10; i++){
            System.out.print("Enter age of student " + (i+1) + ": ");
            Student[i] = sc.nextInt();
        }
        VoteCheck vc = new VoteCheck();
        for(int i = 0; i < 10; i++){
            if(vc.canStudentVote(Student[i])){
                System.out.println("Student " + (i+1) + " is eligible to vote.");
            } else {
                System.out.println("Student " + (i+1) + " is not eligible to vote.");
            }
        }
        
    }
}