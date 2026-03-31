class Person {
    // Attributes
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    // method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Test the copy constructor
    public static void main(String[] args) {
        Person p1 = new Person("Rohan", 25);   // original person
        Person p2 = new Person(p1);            // cloned using copy constructor

        System.out.println("Original Person:");
        p1.displayDetails();

        System.out.println("Cloned Person:");
        p2.displayDetails();
    }
}
