import java.io.*;

// Чтение данных из файла
public class Task2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("D://hello.txt");
        int i = -1;
        StringBuilder str = new StringBuilder();
        while((i = fin.read()) != -1) {
            str.append((char) i);
        }
        System.out.println(str);
        fin.close();
    }
}