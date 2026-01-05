interface Discountable{
    double applyDiscount(double price);
    String getDiscountDetails();
}
abstract class FoodItem{
    private final String itemName;
    private final double price;
    private final int quantity;
    public FoodItem(String itemName, double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice(int quantity);

    public String getItemDetails(){
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
}
class VegItem extends FoodItem implements Discountable{
    public VegItem(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice(int quantity){
        return getPrice() * quantity;
    }
    @Override
    public double applyDiscount(double price){
        return price * 0.9; // 10% discount
    }
    @Override
    public String getDiscountDetails(){
        return "10% discount applied on Veg Item.";
    }

}
// overriding calculateTotalPrice() to include additional charges (e.g., for non-veg items).
class NonVegItem extends FoodItem implements Discountable{
    public NonVegItem(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice(int quantity){
        double basePrice = getPrice() * quantity;
        double additionalCharge = basePrice * 0.15; // 15% additional charge for non-veg
        return basePrice + additionalCharge;
    }
    @Override
    public double applyDiscount(double price){
        return price * 0.85; // 15% discount
    }
    @Override
    public String getDiscountDetails(){
        return "15% discount applied on Non-Veg Item.";
    }
}
public class OnlineFoodDelivery{

    //use polymorphism to handle different types of food items in a single order-processing method.
    public static void processOrder(FoodItem item, int quantity){
        double totalPrice = item.calculateTotalPrice(quantity);
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: " + totalPrice);
        if(item instanceof Discountable){
            Discountable discountableItem = (Discountable) item;
            double discountedPrice = discountableItem.applyDiscount(totalPrice);
            System.out.println(discountableItem.getDiscountDetails());
            System.out.println("Discounted Price: " + discountedPrice);
        }
        System.out.println("---------------------------");
    }
    public static void main(String[] args){
        FoodItem vegItem = new VegItem("Paneer Butter Masala", 200.0, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Curry", 300.0, 1);

        processOrder(vegItem, 2);
        processOrder(nonVegItem, 1);
    }


}
