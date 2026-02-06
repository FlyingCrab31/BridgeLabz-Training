/*Student Result Grouping
○ Scenario: Group students by grade level and collect names.
○ Task: Use Collectors.groupingBy(). */
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class StudentResultGrouping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Grade: ");
            String grade = sc.nextLine();

            students.add(new Student(name, grade));
        }

        // Group students by grade and collect names
        Map<String, List<String>> groupedByGrade =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        // Display result
        System.out.println("\nStudents Grouped By Grade:");
        groupedByGrade.forEach((grade, names) ->
                System.out.println(grade + " → " + names)
        );

        sc.close();
    }
}
