
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Student{

    int id;
    String name;
    int age;
    int marks;

    Student(int id, String name, int age, int marks){
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;

    }

    @Override

    public String toString(){
        return "Student{id="+id+
        ", name ='" +name+'\''+
        ", age =" +age+
        ", marks =" +marks+'}';
    }
}

public class CSVToObject{
    public static void main(String args[]){
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                Student student=new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])
                );
                students.add(student);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
