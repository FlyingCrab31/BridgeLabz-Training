
import java.io.*;

public class LargeFileReadingEfficiency {

    public static void readUsingFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;

        long start = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            //process line
        }
        long end = System.currentTimeMillis();

        System.out.println("File reader time: " + (end - start) + " ms");
        br.close();

    }

    public static void readUsingBufferedReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;

        long start = System.currentTimeMillis();

        while ((line = br.readLine()) != null) {
            //process line
        }
        long end = System.currentTimeMillis();

        System.out.println("Buffered reader time: " + (end - start) + " ms");
        br.close();
    }

    public static void main(String args[]) {
        String filePath = "file.txt";
        try {
            readUsingFileReader(filePath);
            readUsingBufferedReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
