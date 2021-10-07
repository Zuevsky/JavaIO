import java.io.*;

//Сериализация
public class Task9 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Hero Hercules = new Hero("Геркулес");
        Hercules.setHp(-60);
        //System.out.println(Hercules.getHp());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://hello.txt"));
        oos.writeObject(Hercules);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://hello.txt"));
        Hero Hercules1 = (Hero) ois.readObject();
        System.out.println(Hercules1.getHp());
    }
}

class Hero implements Serializable{
    private String name;
    private int hp;

    public void setHp(int hp) {
        if((this.hp + hp) > 100) {
            this.hp = 100;
        } else {
            this.hp += hp;
        }
    }

    public int getHp() {
        return hp;
    }

    public Hero(String name) {
        this.name = name;
        this.hp = 100;
    }
}
