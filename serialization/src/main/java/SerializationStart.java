import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Стартовый класс для упражнения по сериализации/десериализации
 * @deprecated - на этом классе игрался, просьба для тестирования использовать классы из test/java
 */
public class SerializationStart {
    static final String fileName = "fishes.json";

    public static void main(String[] args) throws JsonProcessingException {
        List<Fish> fishes = new ArrayList<>();
        List<Fisherman> fishermans = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }

        fishes = Fish.createFishes();
        fishermans.add(new Fisherman("Vlad", 50, new ArrayList<>(fishes)));
        fishes.remove(1);
        fishermans.add(new Fisherman("Alexey", 40, new ArrayList<>(fishes)));
        fishes.remove(0);
        fishermans.add(new Fisherman("Anna", 16, new ArrayList<>(fishes)));


        System.out.println("Сохраняю в строку");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, fishermans);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Очищаю объекты");
        fishes.clear();
        fishermans.clear();
        System.out.println("Читаю объекты из файла");
        try {
            fishermans = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Fisherman.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Fisherman fisherman : fishermans) {
            System.out.println(fisherman.toString());
        }
    }
}
