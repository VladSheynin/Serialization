import java.io.Serializable;

/**
 * @author Sheynin Vladislav
 * Класс рыба, имеющий параметры: название рыбы (Enum FishType), вес и длина рыбы
 */
public class Fish implements Serializable {
    FishType fishType;
    double weight;
    double length;

    public Fish(FishType fishType, double weight, double length) {
        this.fishType = fishType;
        this.weight = weight;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Рыба вида " + fishType.toString() + ", вес " + weight + ", длина " + length;
    }
}
