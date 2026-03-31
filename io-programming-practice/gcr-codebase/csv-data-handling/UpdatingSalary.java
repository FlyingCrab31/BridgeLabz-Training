import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdatingSalary{

    public static void main(String args[]){
        String inputFile = "employee.csv";
        String outputFile = "updated_employees.csv";


        try(
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile)
        ){
            String line;
            fw.write(br.readLine()+"\n");

            while((line = br.readLine())!=null){
                String[] data  = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);



                if(department.equalsIgnoreCase("IT")){
                    salary=salary+(salary*0.01);
                }

                fw.write(data[0]+","+data[1]+","+department+","+salary+"\n");

            }
            System.out.println("Updated csv created successfully");

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    

}