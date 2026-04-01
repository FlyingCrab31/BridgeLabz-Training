/*Problem Statement:
Create a Java program that copies a large file (e.g., 100MB) from one location to another using Buffered Streams (BufferedInputStream and BufferedOutputStream). Compare the performance with normal file streams.
 */
import java.io.*;

public class BufferedVsUnbuffered {

    public static void main(String[] args) throws Exception {

        byte[] buffer = new byte[4096];

        long start1 = System.nanoTime();
        try (FileInputStream fis = new FileInputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt"); FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\dest.txt")) {

            int bytes;
            while ((bytes = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
            }
        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt")); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\dest.txt"))) {

            int bytes;
            while ((bytes = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytes);
            }
        }
        long end2 = System.nanoTime();

        System.out.println("Unbuffered Time: " + (end1 - start1));
        System.out.println("Buffered Time: " + (end2 - start2));
    }
}
