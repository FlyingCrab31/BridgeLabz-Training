import java.util.Scanner;

public class Cafeteria {

    // Fixed 10 items
    private static final String[] menuItems = {
            "Idli Sambhar",
            "Masala Dosa",
            "Chole Bhature",
            "Veg Sandwich",
            "Paneer Roll",
            "Fried Rice",
            "Noodles",
            "Cold Coffee",
            "Tea",
            "Samosa"
    };

    // Method: display menu with index numbers
    public static void displayMenu() {
        System.out.println("===== Cafeteria Menu =====");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " : " + menuItems[i]); // index + item
        }
        System.out.println("==========================");
    }

    // Method: get item by index (with simple validation)
    public static String getItemByIndex(int index) {
        if (index < 0 || index >= menuItems.length) {
            return null; // or throw an exception if you want
        }
        return menuItems[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu(); // show all items

        System.out.print("Enter the index of the item you want to order: ");
        int choice = scanner.nextInt();

        String selectedItem = getItemByIndex(choice);
        if (selectedItem != null) {
            System.out.println("You selected: " + selectedItem);
        } else {
            System.out.println("Invalid menu index. Please try again.");
        }

        scanner.close();
    }
}
