class Student {
    // Access modifiers as required
    public int rollNumber;     // public
    protected String name;     // protected
    private double CGPA;       // private

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Public method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name       : " + name);
        System.out.println("CGPA       : " + CGPA);
        System.out.println("---------------------------");
    }
}

// Subclass to demonstrate protected member access
class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Can access protected 'name' directly
    public void displayPostgraduateDetails() {
        System.out.println("PG Student Name : " + name); // using protected member
        System.out.println("Roll Number     : " + rollNumber);
        System.out.println("Specialization  : " + specialization);
        System.out.println("CGPA            : " + getCGPA());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Student ug = new Student(101, "Rohan", 8.2);
        ug.displayStudentDetails();

        PostgraduateStudent pg = new PostgraduateStudent(201, "Kiran", 9.0, "Computer Science");
        pg.displayPostgraduateDetails();

        // Modify CGPA using public setter
        pg.setCGPA(9.3);
        pg.displayPostgraduateDetails();
    }
}
