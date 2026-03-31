/*Order Revenue Summary
○ Scenario: Sum order totals per customer.
○ Task: Use Collectors.summingDouble() */
import java.util.*;
import java.util.stream.Collectors;

class Order{
    private String customerName ;
    private double amount;
    public Order(String customerName , double amount){
        this.customerName = customerName;
        this.amount = amount;


    }

    public String getCustomerName(){
        return customerName;

    }
    public double getAmount(){
        return amount;

    }


}
public class OrderRevenue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.println("Enter Number of Orders : ");

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for order " + (i + 1));

            System.out.print("Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Order Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); 

            orders.add(new Order(customerName, amount));
        }
        Map<String, Double> revenueByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println("\nOrder Revenue Summary:");
        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " → " + total)
        );                

    }
    
}
