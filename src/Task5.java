import java.io.*;

public class Task5 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D://hello.txt");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
