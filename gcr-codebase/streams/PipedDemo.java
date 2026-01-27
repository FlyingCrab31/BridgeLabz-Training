/*Implement a Java program where one thread writes data into a PipedOutputStream and another thread reads data from a PipedInputStream.
 */
import java.io.*;

class WriterThread extends Thread {

    PipedOutputStream pos;

    WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            pos.write("Hello from Thread".getBytes());
            pos.close();
        } catch (IOException e) {
        }
    }
}

class ReaderThread extends Thread {

    PipedInputStream pis;

    ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int ch;
            while ((ch = pis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
        }
    }
}

public class PipedDemo {

    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);

        new WriterThread(pos).start();
        new ReaderThread(pis).start();
    }
}
