import java.util.*;

public class InterestCalculator{
public static double calculateInterest(double amount, double rate, int time) throws IllegalArgumentException{

        if(amount <0||rate<0){
            throw new IllegalArgumentException("Amount and rate cannot be negative");
        
        }

        return (amount*rate*time)/100;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        try{

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter time: ");
            int time = sc.nextInt();

            double interest = calculateInterest(amount,rate,time);
            System.out.println("Interest: "+interest);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid input: amount and rate must be positive");
        
        }
    }
}