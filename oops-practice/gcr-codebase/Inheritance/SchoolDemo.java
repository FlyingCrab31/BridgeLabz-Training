class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}
class Teacher extends Person {
    private final String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role   : Teacher");
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    private final String grade;   // e.g., "10th", "B.Tech 2nd Year"

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role : Student");
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    private final String position;   // e.g., "Clerk", "Librarian"

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public void displayRole() {
        System.out.println("Role    : Staff");
        System.out.println("Position: " + position);
    }
}
public class SchoolDemo {
    public static void main(String[] args) {
        Teacher t = new Teacher("Alice", 35, "Mathematics");
        Student s = new Student("Bob", 16, "10th");
        Staff st = new Staff("Charlie", 40, "Librarian");

        t.displayBasicInfo();
        t.displayRole();
        System.out.println();

        s.displayBasicInfo();
        s.displayRole();
        System.out.println();

        st.displayBasicInfo();
        st.displayRole();
    }
}
