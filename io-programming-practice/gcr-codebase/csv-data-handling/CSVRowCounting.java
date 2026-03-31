

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounting{
    public static void main(String args[]){
        String filePath = "students.csv";
        int rowCount = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();

            String line;
            while((line = br.readLine())!=null){
                rowCount++;
            }

            System.out.println("Total records: "+rowCount);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}