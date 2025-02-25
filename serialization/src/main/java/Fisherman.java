import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonPropertyOrder({"name", "age", "address", "bestFishes"})
public class Fisherman {

    //@JsonIgnore
    private String address;
    private String name;
    @JsonProperty("years")
    private int age;
    @JsonDeserialize(as = ArrayList.class, contentAs = Fish.class)
    private List<Fish> bestFishes;

    public Fisherman() {
    }

    public Fisherman(String address, String name, int age, List<Fish> bestFishes) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.bestFishes = bestFishes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Имя='" + name + '\'' + ", возраст=" + age + ", Лучшие трофеи=" + bestFishes.toString() + ((address == null || address.isEmpty()) ? "" : ", адрес " + address) + '}';
    }
}
