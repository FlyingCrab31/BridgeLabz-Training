import java.util.*;
public class AddressBookSystem {

    Map<String, AddressBook> addressBooks=new HashMap<>();

    //uc 5
    public void addresBook(String name){
        if(addressBooks.containsKey(name)) {
            System.out.println("Address book already exists");
            return;
        }

        AddressBook book=new AddressBook();
        book.name=name;
        addressBooks.put(name,book);
        System.out.println("Address book created successfully");
    }

    public AddressBook getAddressBook(String name){
        return addressBooks.get(name);
    }

    //uc 8
    public void searchByCityOrState(String location){
        System.out.println("Searching for people living in "+location);
        for(AddressBook book:addressBooks.values()){
            for(Person p:book.persons){
                if(p.city.equalsIgnoreCase(location)||p.state.equalsIgnoreCase(location)) System.out.println(p);
            }
        }
    }

    public void countCityOrState(String location){
        int count=0;
        for(AddressBook book:addressBooks.values()){
            for(Person p:book.persons){
                if(p.city.equalsIgnoreCase(location)||p.state.equalsIgnoreCase(location)) count++;
            }
        }
        System.out.println("Total people living in "+location+" are "+count);
    }




}
