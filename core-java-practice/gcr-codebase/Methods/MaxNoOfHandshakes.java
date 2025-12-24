import java.util.Scanner;

public class MaxNoOfHandshakes{

     private static int maxHandshakes(int student){
        int max = (student * (student - 1)) / 2;
        return max;
     }
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int student = sc.nextInt();
         System.out.println(maxHandshakes(student));
     }

}