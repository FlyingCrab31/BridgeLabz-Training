class Item {
    // Attributes
    String itemCode;
    String itemName;
    double price;
    
    // Constructor to initialize the Item object
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    
    // Method to display item details
    public void displayDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }
    
    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

class Main {
    public static void main(String[] args) {
        // Create item objects
        Item item1 = new Item("01AA", "Water bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "blackboard", 400.0);
        
        // Display item details
        item1.displayDetails();
        item2.displayDetails();
        item3.displayDetails();
        
        // Calculate total cost for quantity
        System.out.println("Total cost for 3 Water bottles: " + item1.calculateTotalCost(3));
    }
}
