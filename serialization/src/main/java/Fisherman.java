import java.io.Serializable;
import java.util.List;

public class Fisherman implements Serializable {
    String name;
    int age;
    List<Fish> bestFishes;

    public Fisherman() {
    }

    public Fisherman(String name, int age, List<Fish> bestFishes) {
        this.name = name;
        this.age = age;
        this.bestFishes = bestFishes;
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

    public List<Fish> getBestFishes() {
        return bestFishes;
    }

    public void setBestFishes(List<Fish> bestFishes) {
        this.bestFishes = bestFishes;
    }

    @Override
    public String toString() {
        return  "Имя='" + name + '\'' +
                ", возраст=" + age +
                ", Лучшие трофеи=" + bestFishes.toString() +
                '}';
    }
}
