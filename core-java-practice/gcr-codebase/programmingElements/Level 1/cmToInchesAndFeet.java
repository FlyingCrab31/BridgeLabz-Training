import java.util.Scanner;

class CmToInchesAndFeet{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length in centimeters: ");
        double cm = scanner.nextDouble();
        double inches = cm / 2.54;
        double feet = inches / 12;
        System.out.println("inches = " + inches);
        System.out.printf("feet = " + feet);   
    }
}