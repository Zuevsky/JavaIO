import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Работа с zip архивами (создание архива и запись в него)
public class Task11 {
    public static void main(String[] args) throws IOException {
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C://file/archive.zip"));
        ZipEntry entry = new ZipEntry("hello.txt");
        zout.putNextEntry(entry);
        FileInputStream fis = new FileInputStream("C://file/hello.txt");
        byte[] buffer= new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();
        zout.close();
    }
}