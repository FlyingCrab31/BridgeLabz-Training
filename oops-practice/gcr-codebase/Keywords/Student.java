class Student {

    // 1. Static
    static String universityName = "GLA University";    // shared by all students
    private static int totalStudents = 0;               // to count total students

    // 3. Final
    private final int rollNumber;   // cannot be changed once assigned

    // Instance fields
    private String name;
    private String grade;

    // 2. This (constructor)
    public Student(String name, int rollNumber, String grade) {
        this.name = name;                 // using this to refer to instance variable
        this.rollNumber = rollNumber;     // final field initialized in constructor
        this.grade = grade;
        totalStudents++;                  // increase count whenever a student is created
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
    }

    // 4. instanceof usage
    public static void printOrUpdateIfStudent(Object obj) {
        if (obj instanceof Student) {                 // check before using
            Student s = (Student) obj;                // safe cast
            System.out.println("Object is a Student. Displaying details:");
            s.displayDetails();

            // Example: updating grade
            s.updateGrade("A+");
            System.out.println("After updating grade:");
            s.displayDetails();
        } else {
            System.out.println("Given object is not a Student. Cannot operate.");
        }
    }

    public static void main(String[] args) {
        // Create some Student objects
        Student s1 = new Student("Rahul", 101, "B");
        Student s2 = new Student("Priya", 102, "A");

        // Display individual details
        s1.displayDetails();
        s2.displayDetails();

        // Show total students using static method
        Student.displayTotalStudents();

        // instanceof check before operations
        printOrUpdateIfStudent(s1);      // valid Student
        printOrUpdateIfStudent("Hello"); // not a Student
    }
}
