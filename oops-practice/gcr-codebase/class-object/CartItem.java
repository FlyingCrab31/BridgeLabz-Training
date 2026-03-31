class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;
    
    // Constructor to initialize the CartItem object
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Method to add items to the cart
    public void addItem(int additionalQuantity) {
        this.quantity += additionalQuantity;
        System.out.println("Added " + additionalQuantity + " of " + itemName + " to the cart.");
    }
    
    // Method to remove items from the cart
    public void removeItem(int removeQuantity) {
        if (removeQuantity <= this.quantity) {
            this.quantity -= removeQuantity;
            System.out.println("Removed " + removeQuantity + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available in cart.");
        }
    }
    
    // Method to display the total cost
    public void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total cost: $" + totalCost);
    }
    
    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

class Main {
    public static void main(String[] args) {
        // Create a cart item object
        CartItem item = new CartItem("Laptop", 999.99, 1);
        
        // Display initial item details
        item.displayItemDetails();
        
        // Add 2 more laptops to the cart
        item.addItem(2);
        
        // Remove 1 laptop from the cart
        item.removeItem(1);
        
        // Display total cost
        item.displayTotalCost();
    }
}
