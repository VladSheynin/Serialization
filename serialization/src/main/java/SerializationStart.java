import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Стартовый класс для упражнения по сериализации/десериализации
 * @deprecated - на этом классе игрался, просьба для тестирования использовать классы из test/java
 */
public class SerializationStart {
    static final String fileName = "fishes.json";

    public static void main(String[] args) throws JsonProcessingException {
        List<Fish> fishes;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }

        fishes = Fish.createFishes();

        System.out.println("Сохраняю в строку");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, fishes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //String jsonFish = objectMapper.writeValueAsString(fishes);
        //System.out.println(jsonFish);

        System.out.println("Очищаю объекты");
        fishes.clear();
        System.out.println("Читаю объекты из файла");
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
