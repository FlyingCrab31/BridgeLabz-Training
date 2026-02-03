import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingLargeCSV{

    private static final int CHUNK_SIZE = 100;    

    public static void main(String args[]){

        String filePath = "large_file.csv";

        int totalRecord = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();

            List<String> chunk = new ArrayList<>(CHUNK_SIZE);

            while((line = br.readLine()) != null){
                chunk.add(line);

                if(chunk.size() == CHUNK_SIZE){
                    totalRecord = totalRecord+processChunk(chunk);
                    chunk.clear();
               
               
                }
            }

            if(!chunk.isEmpty()){
                totalRecord = totalRecord+processChunk(chunk);

            }

            System.out.println("Total records processed: "+totalRecord);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    private static int processChunk(List<String>chunk ){
        System.out.println("Processed chunk of size: "+chunk.size());
        return chunk.size();
    }
}