/*Create a program that reads a text file and writes its contents into another file, converting all uppercase letters to lowercase.
 */
import java.io.*;

public class UpperToLower {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\dest.txt"));

        int ch;
        while ((ch = br.read()) != -1) {
            bw.write(Character.toLowerCase(ch));
        }

        br.close();
        bw.close();
        System.out.println("Converted successfully.");
    }
}
