public class Person {

    String firstName,lastName,address,city,state,zip,phoneNumber,email;
    public Person(String firstName,String lastName,String address,String city,String state,String zip,String phoneNumber,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    @Override

    public boolean equals(Object obj){
        if(obj==null ||!(obj instanceof Person)) return false;
        Person p=(Person)obj;
        return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
    }

    @Override

    public int hashCode(){
        return (firstName+lastName).toLowerCase().hashCode();
    }

    @Override

    public String toString(){
        return firstName+" "+lastName+" "+address+" "+city+" "+state+" "+zip+" "+phoneNumber+" "+email;
    }
}
