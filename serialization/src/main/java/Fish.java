import java.io.Serializable;

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
