
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        String filePath = "input.txt"; // path to your file

        // try-with-resources ensures the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            // readLine() returns null when EOF is reached
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
