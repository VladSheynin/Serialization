import java.io.File;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование сохранения в файл (сериализация) - стандартная Java
 */
public class SerializeToFile {

    static final String fileName = "fishes.txt";

    public static void main(String[] args) {
        List<Fish> fishes;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        fishes = Fish.createFishes();
        System.out.println("Сохраняю в файл");
        SerializableHelper.writeToFile(file, fishes);
    }
}
