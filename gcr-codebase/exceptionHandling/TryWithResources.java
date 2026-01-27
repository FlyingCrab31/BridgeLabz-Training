import java.io.*;

public class TryWithResources{

    public static void main(String args[]){
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))){
            String firstLine = br.readLine();

            if(firstLine != null){
                System.out.println(firstLine);
            }

            }
            catch(IOException e){
                System.out.println("File not found");
            
            }
        }
    }