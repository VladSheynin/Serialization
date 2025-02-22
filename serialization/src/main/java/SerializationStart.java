import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SerializationStart {
    public static void main(String[] args) {
        List<Fish> fishes;
        String fileName = "fishes.txt";
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

    public static List<Fish> createFishes() {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish(FishType.PIKE, 8.7, 1.05));
        fishes.add(new Fish(FishType.ZANDER, 5.0, 0.81));
        fishes.add(new Fish(FishType.TAIMEN, 25.0, 1.45));
        return fishes;
    }
}
