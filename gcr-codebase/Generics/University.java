
import java.util.ArrayList;
import java.util.List;

abstract class CourseType {

    private final String evaluationName;

    public CourseType(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public abstract double calculateFinalScore(double examMarks,
            double assignmentMarks,
            double researchMarks);
}

// Different evaluation strategies
class ExamCourse extends CourseType {

    public ExamCourse() {
        super("Exam Based");
    }

    @Override
    public double calculateFinalScore(double examMarks,
            double assignmentMarks,
            double researchMarks) {
        return examMarks; // 100% exam
    }
}

class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        super("Assignment Based");
    }

    @Override
    public double calculateFinalScore(double examMarks,
            double assignmentMarks,
            double researchMarks) {
        return assignmentMarks; // 100% assignment
    }
}

class ResearchCourse extends CourseType {

    public ResearchCourse() {
        super("Research Based");
    }

    @Override
    public double calculateFinalScore(double examMarks,
            double assignmentMarks,
            double researchMarks) {
        return 0.2 * examMarks + 0.3 * assignmentMarks + 0.5 * researchMarks;
    }
}
// Generic Course bound to a CourseType

class Course<T extends CourseType> {

    private final String courseCode;
    private final String title;
    private final T courseType; // evaluation strategy

    public Course(String courseCode, String title, T courseType) {
        this.courseCode = courseCode;
        this.title = title;
        this.courseType = courseType;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public T getCourseType() {
        return courseType;
    }

    public double evaluateStudent(double examMarks,
            double assignmentMarks,
            double researchMarks) {
        return courseType.calculateFinalScore(examMarks,
                assignmentMarks,
                researchMarks);
    }

    @Override
    public String toString() {
        return courseCode + " - " + title
                + " [" + courseType.getEvaluationName() + "]";
    }
}

// Department that offers a specific evaluation type
class Department<T extends CourseType> {

    private final String name;
    private final List<Course<T>> courses = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addCourse(Course<T> course) {
        courses.add(course);
    }

    public List<Course<T>> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public void printCourses() {
        System.out.println("Department: " + name);
        for (Course<T> c : courses) {
            System.out.println("  " + c);
        }
    }
}

class UniversityUtils {

    // Accept any list of courses, no matter their concrete evaluation type
    public static void printAnyCourses(
            List<? extends CourseType> courseTypes) {

        for (CourseType type : courseTypes) {
            System.out.println("Course type: " + type.getEvaluationName());
        }
    }

    // Example: process any department's courses using wildcard on CourseType
    public static void printDepartmentsCourses(
            List<? extends Department<? extends CourseType>> departments) {

        for (Department<? extends CourseType> dept : departments) {
            dept.printCourses();
        }
    }
}

public class University {

    public static void main(String[] args) {
        // Evaluation strategies
        ExamCourse examType = new ExamCourse();
        AssignmentCourse assignmentType = new AssignmentCourse();
        ResearchCourse researchType = new ResearchCourse();

        // Courses
        Course<ExamCourse> algo = new Course<>("CS101", "Algorithms", examType);
        Course<AssignmentCourse> oopsLab
                = new Course<>("CS102", "OOP Lab", assignmentType);
        Course<ResearchCourse> mlResearch
                = new Course<>("CS201", "ML Research", researchType);

        // Departments with different evaluation focus
        Department<ExamCourse> csDept = new Department<>("Computer Science");
        csDept.addCourse(algo);

        Department<AssignmentCourse> itDept = new Department<>("Information Technology");
        itDept.addCourse(oopsLab);

        Department<ResearchCourse> aiDept = new Department<>("AI & Research");
        aiDept.addCourse(mlResearch);

        // Work with departments via wildcards
        List<Department<? extends CourseType>> departments = new ArrayList<>();
        departments.add(csDept);
        departments.add(itDept);
        departments.add(aiDept);

        University.printAllDepartments(departments);

        // Evaluate a student in one course
        double score = algo.evaluateStudent(90, 70, 80);
        System.out.println("Student final score in " + algo.getTitle() + " = " + score);
    }

    private static void printAllDepartments(
            List<Department<? extends CourseType>> departments) {
        for (Department<? extends CourseType> dept : departments) {
            dept.printCourses();
        }
    }
}
