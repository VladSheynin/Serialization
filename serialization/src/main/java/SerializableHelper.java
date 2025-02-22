import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableHelper {

    public static void writeToFile(File file, List<Fish> fishes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(fishes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Fish> readFromFile(File file) {
        List<Fish> objects = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Fish>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
