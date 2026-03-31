import java.util.*;

class Contact {
    private String name;
    private String phoneNumber; // exactly 10 digits

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // For easier printing
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}
public class ContactManager {
    private List<Contact> contacts;

    // Custom checked exception
    static class InvalidPhoneNumberException extends Exception {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    private void validatePhone(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }
    }

    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        validatePhone(phoneNumber);
        contacts.add(new Contact(name, phoneNumber));
    }
}


class ContactManager1 extends ContactManager {

    private List<Contact> contacts;

    public ContactManager1() {
        contacts = new ArrayList<>();
    }

    // Add contact (with validation + duplicate check)
    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        validatePhone(phoneNumber); // may throw exception

        // prevent duplicate by phone number
        if (findByPhone(phoneNumber) != null) {
            throw new InvalidPhoneNumberException("Contact with this phone already exists.");
        }

        contacts.add(new Contact(name, phoneNumber)); // ArrayList add()
    }

    // Delete by phone number
    public boolean deleteContact(String phoneNumber) {
        Contact toRemove = findByPhone(phoneNumber);
        if (toRemove != null) {
            return contacts.remove(toRemove); // remove(Object o)
        }
        return false;
    }

    // Search by (partial) name
    public List<Contact> searchByName(String namePart) {
        List<Contact> result = new ArrayList<>();
        String search = namePart.toLowerCase();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(search)) { // String operations
                result.add(c);
            }
        }
        return result;
    }

    // Search by phone (exact)
    public Contact findByPhone(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    // Display all contacts
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }

    // Phone validation method (same as above)
    private void validatePhone(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
        }
    }
}


