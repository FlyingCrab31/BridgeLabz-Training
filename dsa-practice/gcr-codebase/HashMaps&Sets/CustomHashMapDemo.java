
import java.util.Scanner;

// Node class for linked list
class Node {

    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {

    private final int size = 10;
    private final Node[] table;

    public CustomHashMap() {
        table = new Node[size];
    }

    // Hash function
    private int hash(int key) {
        // handle negative keys safely
        return Math.abs(key) % size;
    }

    // Insert or update
    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];
        Node current = head;

        // Check if key exists -> update
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                System.out.println("Key updated successfully.");
                return;
            }
            current = current.next;
        }

        // Insert new node at head of list
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
        System.out.println("Key inserted successfully.");
    }

    // Retrieve
    public Integer get(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next; // move forward
        }
        return null;
    }

    // Delete
    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Key removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Key not found.");
    }

    // Display HashMap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            Node current = table[i];
            if (current == null) {
                System.out.println("null");
                continue;
            }
            while (current != null) {
                System.out.print(" -> [Key: " + current.key + ", Value: " + current.value + "]");
                current = current.next;
            }
            System.out.println(" -> null");
        }
    }
}

public class CustomHashMapDemo {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CustomHashMap map = new CustomHashMap();

            while (true) {
                System.out.println("\n--- Custom HashMap Menu ---");
                System.out.println("1. Insert (Put)");
                System.out.println("2. Retrieve (Get)");
                System.out.println("3. Delete (Remove)");
                System.out.println("4. Display HashMap");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter key: ");
                        int key = sc.nextInt();
                        System.out.print("Enter value: ");
                        int value = sc.nextInt();
                        map.put(key, value);
                    }
                    case 2 -> {
                        System.out.print("Enter key to retrieve: ");
                        int key = sc.nextInt();
                        Integer result = map.get(key);
                        if (result != null) {
                            System.out.println("Value: " + result);
                        } else {
                            System.out.println("Key not found.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter key to remove: ");
                        int key = sc.nextInt();
                        map.remove(key);
                    }
                    case 4 ->
                        map.display();
                    case 5 -> {
                        System.out.println("Exiting.");
                        return;
                    }
                    default ->
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
}
