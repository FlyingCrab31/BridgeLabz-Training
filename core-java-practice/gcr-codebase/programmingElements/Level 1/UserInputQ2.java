import java.util.Scanner;

public class UserInputQ2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double km = scanner.nextDouble();
        double miles = km / 1.6;
        System.out.println(miles);
    }
}
