import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Класс реализующий запись в файл и чтение из файла
 */
public class SerializableHelper {

    /**
     * Запись в файл
     *
     * @param file   - имя файла
     * @param fishes - список рыб
     */
    public static void writeToFile(File file, List<Fish> fishes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(fishes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Чтение из файла
     *
     * @param file - имя файла
     * @return - спиоск рыб
     */
    public static List<Fish> readFromFile(File file) {
        List<Fish> objects = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Fish>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
