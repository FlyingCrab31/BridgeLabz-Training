/*Write a Java program that stores student details (roll number, name, GPA) in a binary file and retrieves it later.
 */
import java.io.*;

public class DataStreamExample {

    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));

        dos.writeInt(101);
        dos.writeUTF("Ravi");
        dos.writeDouble(8.6);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        dis.close();
    }
}
