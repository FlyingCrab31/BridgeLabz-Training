import java.util.*;
public class AddressBook {

    String name;
    List<Person> persons=new ArrayList<>();

    //u1 and u4 add person

    public void addPerson(Person p){
        if(persons.contains(p)){
            System.out.println("Person already exists");
            return;
        }
        persons.add(p);
        System.out.println("Person added successfully");
    }


    //uc2 edit person

    public void editPerson(String firstName, String lastName,Person updated){
        for(int i=0;i<persons.size();i++){
            Person p=persons.get(i);
            if(p.firstName.equalsIgnoreCase(firstName) && p.lastName.equalsIgnoreCase(lastName)){
                persons.set(i,updated);
                System.out.println("Person edited successfully");
                return;

            }
        }
        System.out.println("Person not found");
    }



    //uc 3 delete person

    public void deletePerson(String firstName,String lastName){
        for(int i=0;i<persons.size();i++){
            Person p=persons.get(i);
            if(p.firstName.equalsIgnoreCase(firstName) && p.lastName.equalsIgnoreCase(lastName)){
                persons.remove(i);
                System.out.println("Person deleted successfully");
                return;

            }
        }
        System.out.println("Person not found");
    }

    // sort by name uc-10

    public void sortByName(){
        persons.sort(Comparator.comparing(p->(p.firstName+" "+p.lastName)));
    }

    //uc11 sort by city,state,zip

    public void sortByCityStateZip(String field){
        switch(field){
            case "city": persons.sort(Comparator.comparing(p->p.city));break;
            case "state": persons.sort(Comparator.comparing(p->p.state));break;
            case "zip": persons.sort(Comparator.comparing(p->p.zip));break;
        }
        System.out.println("Sorted by "+field);

    }
    public void displayPersons(){
        for(Person p:persons) System.out.println(p);
    }
}
