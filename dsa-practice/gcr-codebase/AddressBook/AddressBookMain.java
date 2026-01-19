import model.Contact;
import service.*;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        AddressBookService addressBookService = new AddressBookServiceImpl();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Contact newContact = readContactFromConsole(sc);
                    addressBookService.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter first name of contact to edit: ");
                    String nameToEdit = sc.nextLine();
                    System.out.println("Enter new details:");
                    Contact updatedContact = readContactFromConsole(sc);
                    if (addressBookService.editContact(nameToEdit, updatedContact)) {
                        System.out.println("Contact updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter first name of contact to delete: ");
                    String nameToDelete = sc.nextLine();
                    if (addressBookService.deleteContact(nameToDelete)) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    List<Contact> contacts = addressBookService.getAllContacts();
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts to display.");
                    } else {
                        contacts.forEach(System.out::println);
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    private static Contact readContactFromConsole(Scanner sc) {
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Zip: ");
        String zip = sc.nextLine();
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        return new Contact(firstName, lastName, address, city, state, zip, phone, email);
    }
}

