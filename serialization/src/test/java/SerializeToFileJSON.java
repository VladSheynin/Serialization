import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование сохранения в файл (сериализация) - библиотека JacksonJSON
 */
public class SerializeToFileJSON {

    static final String fileName = "fishes.json";

    public static void main(String[] args) {
        List<Fish> fishes;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        fishes = Fish.createFishes();
        System.out.println("Сохраняю в файл");
        try {
            fishes = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Fish.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
