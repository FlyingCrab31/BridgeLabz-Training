class Course {
    // Instance variables
    String courseName;
    int duration;     // in hours or weeks as you prefer
    double fee;

    // Class variable (shared by all Course objects)
    static String instituteName = "GLA Univ.";

    // Constructor to initialize course details
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name   : " + courseName);
        System.out.println("Duration      : " + duration);
        System.out.println("Fee           : " + fee);
        System.out.println("----------------------------");
    }

    // Class method to update institute name for all courses
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    // Test in main
    public static void main(String[] args) {
        Course c1 = new Course("Java Fundamentals", 40, 5000.0);
        Course c2 = new Course("Web Development", 60, 8000.0);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("ABC Academy");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
