

import java.io.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionDecryption{

    private static final String SECRET_KEY = "1234567890123456";

    public static void main(String args[]){
        String filePath = "secure_employees.csv";

        writeEncryptedCSV(filePath);
        System.out.println();
        readDecryptedCSV(filePath);

    }

    private static void writeEncryptedCSV(String filePath){
        try(FileWriter fw = new FileWriter(filePath)){
            fw.write("ID, Name, Email, Salary\n");

            fw.write("1,Anushka,"+
                encrypt("anushkasinghal2@gmail.com")+","+
                encrypt("60000")+"\n");
            

              fw.write("2,Surya,"+
                encrypt("suryasrivastava922@gmail.com")+","+
                encrypt("1000000")+"\n");  
                
                System.out.println("Encryption done");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    private static void readDecryptedCSV(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String line;

            while((line = br.readLine())!=null){
                String[] data = line.split(",");

                String decryptedEmail = decrypt(data[2]);
                String decryptedSalary = decrypt(data[3]);

                System.out.println(
                    "ID: " + data[0]+
                    ", Name: " + data[1]+
                    ", Email: " + decryptedEmail+
                    ", Salary: " +  decryptedSalary
                );

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private static String encrypt(String plaintext)throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

       private static String decrypt(String encryptedtext)throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(),"AES");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedtext));
        return new String(decrypted);
    }
}