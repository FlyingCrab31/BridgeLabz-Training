import java.util.Scanner;
public class FeetToMilesAndYards {
    static void convertFeet(int feet){
        int miles = feet / 5280;
        int yards = (1/3) * feet;
        System.out.println(miles + " Miles " + yards + " Yards");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int feet = sc.nextInt();
        convertFeet(feet);
    }
}