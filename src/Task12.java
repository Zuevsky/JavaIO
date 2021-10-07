import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

// Работа с zip архивами (чтение из архива)
public class Task12 {
    public static void main(String[] args) throws IOException {
        /*ZipInputStream zin = new ZipInputStream(new FileInputStream("C://file/archive.zip"));
        ZipEntry entry;
        while((entry = zin.getNextEntry()) != null) {
            System.out.println(entry.getName());
            System.out.println(entry.getSize());
        }
        zin.close();*/
        ZipFile zipFile = new ZipFile("C://file/archive.zip");
        Enumeration zipEnum = zipFile.entries();
        while(zipEnum.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipEnum.nextElement();
            System.out.println(zipEntry.getSize());
        }
    }
}
