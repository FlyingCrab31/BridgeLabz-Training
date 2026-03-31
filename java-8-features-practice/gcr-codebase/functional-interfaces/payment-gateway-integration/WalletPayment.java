public class WalletPayment implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Paid Rs."+amount+" using Digital Wallet");
    }
}