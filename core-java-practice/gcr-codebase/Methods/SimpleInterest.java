import java.util.Scanner;

public class SimpleInterest{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//Taking inputs from the user for principle, rate & time

        int principle = sc.nextInt();
        int rate = sc.nextInt();
        int time = sc.nextInt();


         int simpleInterest = calculateInterest(principle, rate, time);

        System.out.println("The Simple Interest is  " +simpleInterest + " for Principal  " + principle + " ,Rate of Interest  " + rate + " and Time  "+ time);

    }
    private static int calculateInterest(int principle,int rate,int time){

        int simpleInterest = (principle * rate * time) / 100;

        return simpleInterest;

    }
}