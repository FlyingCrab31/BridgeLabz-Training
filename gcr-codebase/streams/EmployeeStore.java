
import java.io.*;
import java.util.*;

class Employee implements Serializable {

    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String dept, double sal) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = sal;
    }
}

public class EmployeeStore {

    public static void main(String[] args) throws Exception {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Amit", "IT", 50000));
        list.add(new Employee(2, "Neha", "HR", 45000));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("\\\"/C:\\\\Users\\\\HP\\\\Documents\\\\GitHub\\\\BridgeLabz-Training\\\\collections-practice\\\\gcr-codebase\\\\streams\\emp.txt"));
        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\emp.txt"));
        List<Employee> readList = (List<Employee>) ois.readObject();

        for (Employee e : readList) {
            System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
        }
        ois.close();
    }
}
