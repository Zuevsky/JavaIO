import java.io.*;

public class Task4 {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("D://hello.txt");
        String text = "Hello world!";
        writer.write(text);
        writer.append("\n Это пример");
        writer.close();
    }
}