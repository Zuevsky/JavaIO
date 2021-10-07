import java.io.*;

public class Task6 {
    public static void main(String[] args) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter("D://hello.txt"));
        String str = "Hello java";
        buffer.write(str);
        buffer.close();
    }
}