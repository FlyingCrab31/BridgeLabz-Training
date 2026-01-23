
import java.util.*;

enum Department {
    HR, IT, SALES, FINANCE
}

class Employee {

    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> result = new HashMap<>();

        for (Employee e : employees) {
            Department dept = e.getDepartment();
            result.computeIfAbsent(dept, d -> new ArrayList<>())
                    .add(e);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );

        Map<Department, List<Employee>> grouped = groupByDepartment(employees);

        for (Map.Entry<Department, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Example output:
        // HR: [Alice, Carol]
        // IT: [Bob]
    }
}
