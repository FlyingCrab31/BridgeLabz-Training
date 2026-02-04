import java.util.*;

public class PaymentMain{
    public static void main(String args[]){
        PaymentProcessor payment=null;

        System.out.println("Choose payment method: ");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Digital Wallet");
        int choice=sc.nextInt();

        System.out.println("Enter amount: ");
        double amount=sc.nextDouble();

        switch(choice){
            case 1:
                payment=new UPIPayment();
                break;

            case 2:
                payment=new CreditCardPayment();
                break;
            case 3:
                payment=new WalletPayment();
                break; 
                
            default:
                System.out.println("Invalid choice");
                return;    
        }

        payment.pay(amount);
        System.out.println("Enter refucd amount: ");
        double refundAmount=sc.nextDouble();
        payment.refund(refundAmount);
    }
}