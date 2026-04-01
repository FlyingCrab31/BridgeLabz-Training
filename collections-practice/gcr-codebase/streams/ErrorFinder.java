
import java.io.*;

public class ErrorFinder {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("error")) {
                System.out.println(line);
            }
        }
        br.close();
    }
}
