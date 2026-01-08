class Node{
    String itemName;
    int itemId;
    int quantity;
    double price;
    Node next;

    public Node(String itemName, int itemId, int quantity, double price,Node next) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
    
}
public class InventoryManagementSll{
    Node head;

    public void insertAtEnd(String itemName, int itemId, int quantity, double price){
        Node newNode = new Node(itemName, itemId, quantity, price, null);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtBegining(String itemName, int itemId, int quantity, double price){
        this.head = new Node(itemName,itemId,quantity,price,null);
    }

    public void insertAtSpecificPosition(String itemName, int itemId, int quantity, double price){
        Node node = new Node(itemName, itemId, quantity, price,null);
        if(head == null){
            head = node;
        }
        else{
            Node current = head;
            int count = 1;
            while(current.next != null && count < 3){
                current = current.next;
                count++;
            }
            current.next = node;
        }


    }

    public void deleteByRoll(int itemId){

        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.itemId == itemId){
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        //for searching the particular roll No.
        while(current != null && current.itemId != itemId){
            previous = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("Record not found");
            return;
        }
        previous.next = current.next;
    }
    public Node searchById(int itemId){
        Node current = head;
        if(head == null){
            System.out.println("Not found");
            return null;
        }
        if(head.itemId == itemId){
            head= head.next;
            return current;
            
        }
        else{
            while(current != null && current.itemId != itemId){
                current= current.next;
            }
            if(current==null){
                 System.out.println("Not found");
                 return null;
                }
            return current;
        }
    }


    public Node searchByName(String itemName){
        Node current = head;
        if(head == null){
            System.out.println("Not found");
            return null;
        }
        if(head.itemName.equals(itemName)){
            head= head.next;
            return current;
            
        }
        else{
            while(current != null && !current.itemName.equals(itemName)){
                current= current.next;
            }
            if(current==null){
                 System.out.println("Not found");
                 return null;
                }
            return current;
        }
    }
    public void updateGradeById(int itemId){
        Node current = head;
        if(head == null){
            System.out.println("Not Found");
            return;
        }
        if(head.itemId == itemId){
            head.quantity += 5;
        }
        else{
            while(current != null && current.itemId != itemId){
                current = current.next;
            }
            if(current == null){
                System.out.println("Not Found");
                return;
            }
            current.quantity += 5;
        }
    }
    public double totalValue(){
        Node current = head;
        double res = 0.0;
        if(head == null){
            System.out.println("Empty List");
        }
        if(current.next == null) return current.price * current.quantity;

        while(current!=null){
            res = res + (current.price * current.quantity);
            current = current.next;
        }
        return res;
    }
    
    public void display(){
        Node current = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(current != null){
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
    //Sort the inventory based on Item Name or Price in ascending or descending order.
    public void sortByName(){
        if(head == null || head.next == null){
            return;
        }
        Node current = head;
        Node index = null;
        String tempName;
        int tempId, tempQuantity;
        double tempPrice;

        while(current != null){
            index = current.next;
            while(index != null){
                if(current.itemName.compareTo(index.itemName) > 0){
                    //swap
                    tempName = current.itemName;
                    tempId = current.itemId;
                    tempQuantity = current.quantity;
                    tempPrice = current.price;

                    current.itemName = index.itemName;
                    current.itemId = index.itemId;
                    current.quantity = index.quantity;
                    current.price = index.price;

                    index.itemName = tempName;
                    index.itemId = tempId;
                    index.quantity = tempQuantity;
                    index.price = tempPrice;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    //Sort by Price
    public void sortByPrice(){
        if(head == null || head.next == null){
            return;
        }
        Node current = head;
        Node index = null;
        String tempName;
        int tempId, tempQuantity;
        double tempPrice;

        while(current != null){
            index = current.next;
            while(index != null){
                if(current.price > index.price){
                    //swap
                    tempName = current.itemName;
                    tempId = current.itemId;
                    tempQuantity = current.quantity;
                    tempPrice = current.price;

                    current.itemName = index.itemName;
                    current.itemId = index.itemId;
                    current.quantity = index.quantity;
                    current.price = index.price;

                    index.itemName = tempName;
                    index.itemId = tempId;
                    index.quantity = tempQuantity;
                    index.price = tempPrice;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    //main method
    public static void main(String[] args) {
        InventoryManagementSll inventory = new InventoryManagementSll();
        inventory.insertAtEnd("Laptop", 101, 10, 750.50);
        inventory.insertAtEnd("Smartphone", 102, 20, 500.00);
        inventory.insertAtBegining("Tablet", 103, 15, 300.75);
        inventory.insertAtSpecificPosition("Headphones", 104, 25, 150.25);

        System.out.println("Inventory List:");
        inventory.display();

        System.out.println("\nTotal Inventory Value: $" + inventory.totalValue());

        System.out.println("Searching for Item ID 102:");
        Node foundItem = inventory.searchById(102);
        if(foundItem != null){
            System.out.println("Found Item - Name: " + foundItem.itemName + ", Quantity: " + foundItem.quantity + ", Price: " + foundItem.price);
        }

        System.out.println("\nUpdating Quantity for Item ID 101:");
        inventory.updateGradeById(101);
        inventory.display();

        System.out.println("\nSorting Inventory by Name:");
        inventory.sortByName();
        inventory.display();

        System.out.println("\nSorting Inventory by Price:");
        inventory.sortByPrice();
        inventory.display();

        System.out.println("\nDeleting Item ID 103:");
        inventory.deleteByRoll(103);
        inventory.display();
    }


}