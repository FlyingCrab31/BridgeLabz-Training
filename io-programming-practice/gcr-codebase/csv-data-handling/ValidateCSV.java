

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV{

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static void main(String args[]){
 
        String filePath = "users.csv";

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();

            while((line = br.readLine())!=null){
                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean valid = true;


                if(!emailPattern.matcher(email).matches()){
                    System.out.println("Invalid email: "+line);
                    valid=false;
                }

                if(!phone.matches("\\d{10}")){
                    System.out.println("Invalid phone: "+line);
                    valid = false;
                }

                if(!valid){
                    System.out.println("Row rejected");
                }
            }


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}