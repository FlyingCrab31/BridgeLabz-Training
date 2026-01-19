package service;
import model.Contact;
import java.util.List;

public interface AddressBookService {

    void addContact(Contact contact);                 // UC2, UC5

    boolean editContact(String firstName, Contact updatedData);   // UC3

    boolean deleteContact(String firstName);         // UC4

    List<Contact> getAllContacts();                  // helper
}
