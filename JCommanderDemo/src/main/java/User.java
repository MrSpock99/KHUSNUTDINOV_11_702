
import java.io.Serializable;
public class User implements Serializable{
    private String name;
    private int age;
    private boolean isHuman;



    public User(String name, int age, boolean isHuman) {
        this.name = name;
        this.age = age;
        this.isHuman = isHuman;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Age: " + age + "\n" + "isHuman: " + isHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}
