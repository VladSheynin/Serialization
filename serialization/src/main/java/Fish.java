import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Класс рыба, имеющий параметры: название рыбы (Enum FishType), вес и длина рыбы
 */
public class Fish implements Serializable {
    FishType fishType;
    double weight;
    double length;

    public Fish() {
    }

    public Fish(FishType fishType, double weight, double length) {
        this.fishType = fishType;
        this.weight = weight;
        this.length = length;
    }

    /**
     * Создает объекты - рыбы с характеристиками название, вес, длина
     *
     * @return список рыб
     */
    public static List<Fish> createFishes() {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish(FishType.PIKE, 8.7, 1.05));
        fishes.add(new Fish(FishType.ZANDER, 5.0, 0.81));
        fishes.add(new Fish(FishType.TAIMEN, 25.0, 1.45));
        fishes.add(new Fish(FishType.PERCH, 1.2, 0.4));
        return fishes;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    @Override
    public String toString() {
        return "Рыба вида " + fishType.toString() + ", вес " + weight + " кг, длина " + length + " см";
    }
}
