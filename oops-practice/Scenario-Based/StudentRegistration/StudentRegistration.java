import java.util.*;
//// Main class implementing RegistrationService

//Abstration for registration service
interface RegistrationService {
    void enrollCourse(Student student, String course) throws CourseLimitExceedException;
    void dropCourse(Student student, String course);
    void assignGrades(Student student, String courseCode, String grade);
}

//Base class representing a person 

class Person{
    protected String name;
    protected int age;


    //Constructor
    public Person(String name , int age){
        this.name = name;
        this.age = age;

    }

    //Getter methods 
    public String getName(){
        return name;

    }
    public int getAge(){
        return age;
    }

}

//// Custom exception when course limit exceeds
class CourseLimitExceedException extends Exception {
    public CourseLimitExceedException(String message) {
        super(message);
    }
    
}

class Course {
    private String courseName;
    private String courseCode;
   

    //Constructor
    public Course(String courseName, String courseCode, int maxStudents) {
        this.courseName = courseName;
        this.courseCode = courseCode;

    }

    //Getter methods
    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }


    
}



class Student extends Person {

    private int studentId;
    private List<Course> courses;
    private HashMap<String , String> grades;

    //Constructor 
    public Student (int studentId, String name, int age){
        super(name , age) ; //Calling person constructor
        this.studentId = studentId;
        courses = new ArrayList<>();
        grades = new HashMap<>();

    }

    //getter for student Id 
    public int getStudentId(){
        return studentId;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addGrade(String courseCode, String grade) {
        grades.put(courseCode, grade);
    }
    


    // Drop a course
    public void removeCourse(String course) {
        courses.remove(course);
        grades.remove(course);
    }

    //Assign grade 
    public void viewGrades(){
        System.out.println("Grades for " + name + ":");
        for(String course : grades.keySet()){
            System.out.println(course + ":" + grades.get(course));
        }
    }

    // get number of enrolled courses
    public int getEnrolledCourseCount(){
        return courses.size();
    }
    
}




public class StudentRegistration implements RegistrationService {
    private static final int MAX_COURSES = 3;

    public void enrollCourse(Student student, Course course) throws CourseLimitExceedException {
        if (student.getEnrolledCourseCount() >= MAX_COURSES) {
            throw new CourseLimitExceedException("Cannot enroll in more than " + MAX_COURSES + " courses.");
        }
        student.enrollCourse(course);
        System.out.println("Enrolled in course: " + course.getCourseName());
    }

    @Override
    public void dropCourse(Student student, String course) {
        student.removeCourse(course);
        System.out.println("Dropped course: " + course);
    }

    
    public void assignGrade(Student student, String courseCode, String grade) {
        student.addGrade(courseCode, grade);
    }

    //Main Method
    public static void main(String[] args) {
        StudentRegistration service = new StudentRegistration();

        Student student = new Student(101, "Rishabh", 21);

        Course c1 = new Course("CS101", "Java Programming",9);
        Course c2 = new Course("CS102", "Data Structures",10);
        Course c3 = new Course("CS103", "Operating Systems",15);
        Course c4 = new Course("CS104", "Database Systems",20);

        try {
            service.enrollCourse(student, c1);
            service.enrollCourse(student, c2);
            service.enrollCourse(student, c3);
            service.enrollCourse(student, c4); // Exception will occur
        } catch (CourseLimitExceedException e) {
            System.out.println(e.getMessage());
        }

        service.assignGrade(student, "CS101", "A");
        service.assignGrade(student, "CS102", "B+");

        student.viewGrades();
    }

    @Override
    public void enrollCourse(Student student, String course) throws CourseLimitExceedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assignGrades(Student student, String courseCode, String grade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    
}