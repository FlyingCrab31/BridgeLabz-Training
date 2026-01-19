
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWriter {

    public static void main(String[] args) {

        String filePath = "input.txt";

        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in)); BufferedWriter writer
                = new BufferedWriter(new FileWriter(filePath))) {

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while ((line = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break; // stop on "exit"
                }
                writer.write(line);
                writer.newLine(); // write each input as a new line
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
