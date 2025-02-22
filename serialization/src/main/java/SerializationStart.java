import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Стартовый класс для упражнения по сериализации/десериализации
 */
public class SerializationStart {
    static final String fileName = "fishes.txt";

    public static void main(String[] args) {
        List<Fish> fishes;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        fishes = createFishes();
        System.out.println("Сохраняю в файл");
        SerializableHelper.writeToFile(file, fishes);
        System.out.println("Очищаю объекты");
        fishes.clear();
        System.out.println("Читаю объекты из файла");
        fishes = SerializableHelper.readFromFile(file);
        for (Fish fish:fishes) {
            System.out.println(fish.toString());
        }
    }

    /**
     * Создает объекты - рыбы с характеристиками название, вес, длина
     * @return список рыб
     */
    public static List<Fish> createFishes() {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish(FishType.PIKE, 8.7, 1.05));
        fishes.add(new Fish(FishType.ZANDER, 5.0, 0.81));
        fishes.add(new Fish(FishType.TAIMEN, 25.0, 1.45));
        return fishes;
    }
}
