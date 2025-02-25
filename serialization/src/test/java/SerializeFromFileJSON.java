import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование чтения из файла (десериализация) - библиотека JacksonJSON
 */
public class SerializeFromFileJSON {

    static final String fileName = "fishes.json";

    public static void main(String[] args) {
        List<Fish> fishes;
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        try {
            fishes = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Fish.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Fish fish : fishes) {
            System.out.println(fish.toString());
        }
    }
}
