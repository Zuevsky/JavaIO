import java.io.*;

// Создание и запись данных в файл
public class Task1 {
    public static void main(String[] args) throws IOException {
        String str = "Hello";
        String str2 = " World!";
        FileOutputStream fos = new FileOutputStream("D://hello.txt", true);
        byte[] buffer = str.getBytes();
        fos.write(buffer);
        buffer = str2.getBytes();
        fos.write(buffer);
        fos.close();
    }
}
