import java.util.Scanner; 

public class TotalPurchase {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int unitPrice = Sc.nextInt();
        int quantity = Sc.nextInt();
        int totalCost = unitPrice * quantity;
        System.out.println(totalCost);
    }
}
    