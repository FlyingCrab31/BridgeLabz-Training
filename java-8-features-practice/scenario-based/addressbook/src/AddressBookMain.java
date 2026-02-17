import java.util.*;
public class AddressBookMain {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AddressBookSystem system=new AddressBookSystem();
        System.out.println("Welcome to Address Book");

        while(true){
            System.out.println("Enter 1 to create a new address book");
            System.out.println("Enter 2 to add person");
            System.out.println("Enter 3 edit person");
            System.out.println("Enter 4 delete person");
            System.out.println("Enter 5 Search by city or state");
            System.out.println("Enter 6 count by city or state");
            System.out.println("Enter 7 sort by name");
            System.out.println("Enter 8 sort by city,state,zip");
            System.out.println("Enter 9 display all");
            System.out.println("Enter 10 file io");
            System.out.println("Enter 11 save to database ");
            System.out.println("Enter 12 t exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter name of the address book");
                    String name=sc.nextLine();
                    system.addresBook(name);
                    break;

                case 2:
                    System.out.println(" address book name");
                    String bookName=sc.nextLine();
                    AddressBook book=system.getAddressBook(bookName);
                    if(book !=null){
                        System.out.println("Enter first Name: ");
                        String firstName=sc.nextLine();
                        System.out.println("Enter last Name: ");
                        String lastName=sc.nextLine();
                        System.out.println("Enter address: ");
                        String address=sc.nextLine();
                        System.out.println("Enter city: ");
                        String city=sc.nextLine();
                        System.out.println("Enter state: ");
                        String state=sc.nextLine();
                        System.out.println("Enter zip: ");
                        String zip=sc.nextLine();
                        System.out.println("Enter phone number: ");
                        String phoneNumber=sc.nextLine();
                        System.out.println("Enter email: ");
                        String email=sc.nextLine();
                        book.addPerson(new Person(firstName,lastName,address,city,state,zip,phoneNumber,email));
                    }
                    break;

                case 3:
                    System.out.println("Address book name");
                    bookName=sc.nextLine();
                    book=system.getAddressBook(bookName);
                    if(book!=null){
                        System.out.println("Enter first Name: ");
                        String first=sc.nextLine();
                        System.out.println("Enter last Name: ");
                        String last=sc.nextLine();
                        System.out.println("Enter new first Name: ");
                        String newFirst=sc.nextLine();
                        System.out.println("Enter new last Name: ");
                        String newLast=sc.nextLine();
                        Person updated=new Person(newFirst,newLast,book.persons.get(0).address,book.persons.get(0).city,book.persons.get(0).state,book.persons.get(0).zip,book.persons.get(0).phoneNumber,book.persons.get(0).email);
                        book.editPerson(first,last,updated);
                    }
                    break;


                case 4:
                    System.out.println("Address book name");
                    bookName=sc.nextLine();
                    book=system.getAddressBook(bookName);
                    if(book!=null){
                        System.out.println("Enter first Name: ");
                        String first1=sc.nextLine();
                        System.out.println("Enter last Name: ");
                        String last1=sc.nextLine();
                        book.deletePerson(first1,last1);
                    }
                    break;
                    case 5:
                    System.out.println("Enter location to search");
                    String location=sc.nextLine();
                    system.searchByCityOrState(location);
                    break;

                case 6:
                    System.out.println("Enter location to search");
                    location=sc.nextLine();
                    system.countCityOrState(location);
                    break;

                    case 7:
                    System.out.println("Enter address book name");
                    bookName=sc.nextLine();
                    book=system.getAddressBook(bookName);
                    if(book !=null)book.sortByName();
                    break;

                case 8:
                    System.out.println("Address book name");
                    bookName=sc.nextLine();
                    book=system.getAddressBook(bookName);
                    if(book!=null){
                        System.out.println("Enter field to sort by");
                        String field=sc.nextLine();
                        book.sortByCityStateZip(field);
                    }
                    break;
                    case 9:
                    System.out.println("Address book name");
                    bookName=sc.nextLine();
                    book=system.getAddressBook(bookName);
                    if(book!=null)book.displayPersons();
                    break;

                case 10:
                    System.out.println("Address book name");
                    book=system.getAddressBook(sc.nextLine());
                    if(book!=null){
                        System.out.println("Enter file path");
                        String path=sc.nextLine();
                        IOHandler.writeToFile(book,path);
                        IOHandler.readFromFile(book,path);
                    }
                    break;
                    case 11:
                    System.out.println("Address book name");
                    book=system.getAddressBook(sc.nextLine());
                    if(book!=null)IOHandler.saveToDB(book);
                    break;

                case 12:
                    System.exit(0);
                    break;


            }
        }
    }
}
