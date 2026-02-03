

import java.io.FileWriter;
import java.io.IOException;

public class WritingCSV{

    public static void main(String args[]){
        String filePath="employees.csv";

        try(FileWriter writer =new FileWriter(filePath)){
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,Rahul,IT,60000\n");
            writer.append("2,Priya,HR,50000\n");
            writer.append("3,Rajesh,Finance,70000\n");
            writer.append("4,Neha,IT,65000\n");
            writer.append("5,Amit,HR,55000\n");


            System.out.println("CSV file created successfully");
        }catch(IOException e){
            e.printStackTrace();
        
        }
    }
}