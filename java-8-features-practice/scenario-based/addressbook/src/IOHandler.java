import java.util.*;
import java.io.*;

public class IOHandler {

    //uc 12
    public static void writeToFile(AddressBook book,String path){
        new Thread(()->{
            try(BufferedWriter bw= new BufferedWriter(new FileWriter(path))){
                for(Person p: book.persons){
                    bw.write(p.toString());
                    bw.newLine();

                }
                System.out.println("File saved successfully");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    public static void readFromFile(AddressBook book,String path){
        new Thread(()->{
            try(BufferedReader br=new BufferedReader(new FileReader(path))){
                String line;
                while((line=br.readLine())!=null){
                    String[] parts=line.split(", ");
                    book.addPerson(new Person(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7]));
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }).start();
    }


    public static void saveToDB(AddressBook book){
        new Thread(()->{
            System.out.println("Saving "+book.persons.size()+" to DB");
            try{
                Thread.sleep(1000);}
            catch(InterruptedException e){}
            System.out.println("Saved successfully");

        }).start();

    }

}
