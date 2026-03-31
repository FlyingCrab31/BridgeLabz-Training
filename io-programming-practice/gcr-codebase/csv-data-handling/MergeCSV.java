
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV{

    public static void main(String[] args){
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String output = "merged_students.csv";


        Map<String, String> studentDetails = new HashMap<>();

        try(BufferedReader br1 = new BufferedReader(new FileReader(file1))){
            br1.readLine();
            String line;

            while((line = br1.readLine()) != null){
                String[] data = line.split(",");
                studentDetails.put(data[0],data[1]+","+data[2]);

            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        try(
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter fw = new FileWriter(output)
        ){
            fw.write("ID,Name,Age,Marks,Grade\n");
            br2.readLine();
            String line;

            while((line = br2.readLine())!=null){
                String[] data = line.split(",");
                String id = data[0];

                if(studentDetails.containsKey(id)){
                    fw.write(id+","+
                        studentDetails.get(id)+","+
                        data[1]+","+
                        data[2]+"\n"
                    );
                }
            }
            System.out.println("CSVfiles merged ");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}