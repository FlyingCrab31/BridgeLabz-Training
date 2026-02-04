import java.util.*;

public class DigitalPaymentInterface{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter payment method (UPI/Credit Card/Digital Wallet): ");
        String paymentMethod=sc.nextLine().toLowerCase();


        Payment payment;

        switch (paymentMethod) {
            case "upi":
                payment=new UPI();
                break;
            case "credit card":
                payment=new CreditCard();
                break;
            case "digital wallet":
                payment=new DigitalWallet();
                break;
            default:
                System.out.println("Invalid payment method");
                return;
        }

       

        
        System.out.print("Enter amount: ");
        double amount=sc.nextDouble();
        payment.pay(amount);


    }
}