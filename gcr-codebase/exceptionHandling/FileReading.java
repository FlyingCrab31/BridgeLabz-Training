import java.io.*;
import java.util.*;

public class FileReading{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName=sc.nextLine();


        try{

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}