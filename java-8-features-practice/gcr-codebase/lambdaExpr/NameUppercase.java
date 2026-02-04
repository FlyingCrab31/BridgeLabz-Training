
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class NameUppercase {

    public static void main(String[] args) {

        // Sample employee list
        List<Employee> employees = Arrays.asList(
                new Employee("ravi kumar"),
                new Employee("sita sharma"),
                new Employee("aman singh")
        );

        // Use stream + String::toUpperCase
        List<String> uppercasedNames = employees.stream()
                .map(Employee::getName) // get the name
                .map(String::toUpperCase) // convert to UPPERCASE using method reference
                .collect(Collectors.toList());

        // Print names prepared for HR letter
        System.out.println("Employee names in uppercase for HR letter:");
        uppercasedNames.forEach(System.out::println);
    }
}
