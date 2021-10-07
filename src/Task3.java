import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        String str = "Hello!";
        FileOutputStream fos = new FileOutputStream("D://hello.txt");
        PrintStream printStream = new PrintStream(fos);
        printStream.println(str);
        printStream.print("Hello");
        printStream.println(" world!");
        printStream.printf("Имя: %s, Возраст: %d", "Иван", 12);
        fos.close();
    }
}
