package bankaccount;

import java.util.*;

public class BankMain{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(balance);

        System.out.print("Enter amount to withdrawl: ");
        double amount = sc.nextDouble();

        try{
            acc.withdrawl(amount);
        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());

        }
    }
}