public class CreditCardPayment implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Paid Rs."+amount+" using Credit Card");
    }
}