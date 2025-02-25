import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование сохранения в файл (сериализация) - библиотека JacksonJSON
 */
public class SerializeToFileJSON {

    static final String fileName = "fishes.json";

    public static void main(String[] args) {
        List<Fish> fishes;
        List<Fisherman> fishermans = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //генерирую рыбаков с разными трофеями
        fishes = Fish.createFishes();
        fishermans.add(new Fisherman("Vlad", 50, new ArrayList<>(fishes)));
        fishes.remove(1);
        fishermans.add(new Fisherman("Alexey", 40, new ArrayList<>(fishes)));
        fishes.remove(0);
        fishermans.add(new Fisherman("Anna", 16, new ArrayList<>(fishes)));

        System.out.println("Сохраняю в файл");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, fishermans);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
