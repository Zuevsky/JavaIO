import java.io.*;

// Управление каталогами и файлами
public class Task10 {
    public static void main(String[] args) throws IOException {
        File dir = new File("C://file", "111.txt");
        File dir1 = new File("C://file");
        File dir2 = new File("C://file/dir");
        boolean result = dir.createNewFile();
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.getName());
        System.out.println(dir.getParent());
        System.out.println(dir.length());
        String[] arr = dir1.list();
        dir2.mkdir();
        File dir3 = new File("C://file", "222.txt");
        dir.renameTo(dir3);
        /*if(dir.exists()) {
            dir.delete();
        } else {
            System.out.println("Файл не найден");
        }*/
    }
}