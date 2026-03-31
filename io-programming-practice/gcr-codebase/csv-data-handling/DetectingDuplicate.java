
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectingDuplicate{
    public static void main(String args[]){
        String filePath = "data.csv";

        Set<String> seenId = new HashSet<>();

        boolean duplicateFound = false;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                String id = data[0];

                if(!seenId.add(id)){
                    System.out.println("Duplicate records: " + line);
                    duplicateFound=true;
                }
            }
            if(!duplicateFound){
                System.out.println("No duplicate records found");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}