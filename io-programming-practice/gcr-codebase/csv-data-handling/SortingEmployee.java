import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Employees{
    String id;
    String name;
    String department;
    double salary;


    Employees(String id, String name, String department,double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}


public class SortingEmployee{

    public static void main(String args[]){
        String filePath = "employee.csv";

        List<Employees> employees = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();

            while((line=br.readLine())!=null){
                String[] data = line.split(",");

                employees.add(new Employees(
                    data[0],
                    data[1],
                    data[2],
                    Double.parseDouble(data[3])
                ));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        employees.sort((e1,e2)->Double.compare(e2.salary,e1.salary));

        System.out.println("Top 5 highest paid employees:  ");
        for(int i = 0; i<Math.min(5,employees.size()); i++){
            Employees e = employees.get(i);
            System.out.println(
                e.name+"    |     "+e.department+"     | salary:    "+e.salary
            );
        }
    }
}