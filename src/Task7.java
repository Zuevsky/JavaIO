import java.io.*;

public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader("D://hello.txt"));
        String c;
        while((c = buffer.readLine()) != null) {
            System.out.println(c);
        }
        buffer.close();
    }
}
