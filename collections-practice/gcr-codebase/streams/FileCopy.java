
import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt"); FileOutputStream fos = new FileOutputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\dest.txt")) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
