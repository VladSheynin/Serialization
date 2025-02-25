import java.io.File;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование чтения из файла (десериализация) - стандартная Java
 */
public class SerializeFromFile {

    static final String fileName = "fishes.txt";

    public static void main(String[] args) {
        List<Fish> fishes;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        System.out.println("Читаю объекты из файла");
        fishes = SerializableHelper.readFromFile(file);
        for (Fish fish : fishes) {
            System.out.println(fish.toString());
        }
    }
}
