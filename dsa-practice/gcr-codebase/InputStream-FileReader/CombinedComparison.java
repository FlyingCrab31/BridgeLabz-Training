
import java.io.*;
import java.nio.charset.StandardCharsets;

public class CombinedComparison {

    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) throws Exception {

        // StringBuilder vs StringBuffer
        String word = "hello";

        // StringBuffer
        StringBuffer sbf = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append(word);
        }
        long end = System.nanoTime();
        long timeBuffer = end - start;

        // StringBuilder
        StringBuilder sbd = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            sbd.append(word);
        }
        end = System.nanoTime();
        long timeBuilder = end - start;

        System.out.println("StringBuffer time (ns):  " + timeBuffer);
        System.out.println("StringBuilder time (ns): " + timeBuilder);

        // FileReader and InputStreamReader word count
        String filePath = "output.txt"; // path to a large text file for testing

        // Using FileReader (character stream)
        long fileReaderWordCount = 0;
        start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String p : parts) {
                    if (!p.isEmpty()) {
                        fileReaderWordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.nanoTime();
        long timeFileReader = end - start;

        // Using InputStreamReader (byte -> char with charset)
        long isrWordCount = 0;
        start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(filePath); java.io.InputStreamReader isr = new java.io.InputStreamReader(fis, StandardCharsets.UTF_8); BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String p : parts) {
                    if (!p.isEmpty()) {
                        isrWordCount++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.nanoTime();

        long timeInputStreamReader = end - start;

        System.out.println("\n--- Word Count Results ---");
        System.out.println("FileReader word count:        " + fileReaderWordCount);
        System.out.println("FileReader time (ns):         " + timeFileReader);
        System.out.println("InputStreamReader word count: " + isrWordCount);
        System.out.println("InputStreamReader time (ns):  " + timeInputStreamReader);
    }
}
