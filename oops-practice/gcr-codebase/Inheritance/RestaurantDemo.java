class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID  : " + id);
    }
}
interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    private final String speciality;   // e.g., "Italian", "Indian"

    public Chef(String name, int id, String speciality) {
        super(name, id);
        this.speciality = speciality;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking " + speciality + " dishes.");
    }

    public void displayRole() {
        System.out.println("Role       : Chef");
        System.out.println("Speciality : " + speciality);
    }
}
class Waiter extends Person implements Worker {
    private final int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name +
                           " is serving customers at " + tablesAssigned + " tables.");
    }

    public void displayRole() {
        System.out.println("Role           : Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}
public class RestaurantDemo {
    public static void main(String[] args) {
        Worker chef = new Chef("Arjun", 101, "Indian");
        Worker waiter = new Waiter("Riya", 201, 5);

        // As workers
        chef.performDuties();
        waiter.performDuties();

        System.out.println();

        // As persons with roles (downcast to access specific methods if needed)
        Chef c = (Chef) chef;
        Waiter w = (Waiter) waiter;

        c.displayBasicInfo();
        c.displayRole();

        System.out.println();

        w.displayBasicInfo();
        w.displayRole();
    }
}

