
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamReader1 {

    public static void main(String[] args) {
        String filePath = "input.txt"; // path to your UTF-8 file

        // try-with-resources to ensure all streams are closed
        try (FileInputStream fis = new FileInputStream(filePath); InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);   // print each line as characters
            }

        } catch (IOException e) {
            e.printStackTrace(); // handle IO / encoding-related exceptions
        }
    }
}
