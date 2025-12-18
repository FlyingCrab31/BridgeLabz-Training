import java.util.Scanner;
public class ageOfHarry {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int yearOfBirth = scanner.nextInt();
        int currentYear = scanner.nextInt();
        int age = currentYear - yearOfBirth;
        System.out.println(age);
        
    }
}