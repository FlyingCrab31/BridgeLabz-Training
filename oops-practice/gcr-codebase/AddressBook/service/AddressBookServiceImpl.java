package service;
import model.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBookServiceImpl implements AddressBookService {

    private final List<Contact> contacts = new ArrayList<>();   // UC5: collection

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public boolean editContact(String firstName, Contact updatedData) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contact.setAddress(updatedData.getAddress());
                contact.setCity(updatedData.getCity());
                contact.setState(updatedData.getState());
                contact.setZip(updatedData.getZip());
                contact.setPhoneNumber(updatedData.getPhoneNumber());
                contact.setEmail(updatedData.getEmail());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteContact(String firstName) {
        return contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    @Override
    public List<Contact> getAllContacts() {
        return Collections.unmodifiableList(contacts);
    }
}