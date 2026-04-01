/*Write a Java program that converts an image file into a byte array and then writes it back to another image file.
 */
import java.io.*;

public class ImageByteArray {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\img.jpeg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int data;
        while ((data = fis.read()) != -1) {
            baos.write(data);
        }

        byte[] imageBytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\copy.jpeg");

        while ((data = bais.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();
        System.out.println("Image copied successfully.");
    }
}
