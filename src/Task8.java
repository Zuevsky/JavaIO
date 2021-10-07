import java.io.*;

public class Task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String text;
        System.out.println("10 + 5 = ?");
        while(!((text = buffer.readLine()).equals("stop") | text.equals("15"))) {
            System.out.println("10 + 5 = ?");
        }
        buffer.close();
    }
}
