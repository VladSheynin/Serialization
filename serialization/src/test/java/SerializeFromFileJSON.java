import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sheynin Vladislav
 * Тестирование чтения из файла (десериализация) - библиотека JacksonJSON
 */
public class SerializeFromFileJSON {

    static final String fileName = "fishes.json";

    public static void main(String[] args) {
        List<Fish> fishes;
        List<Fisherman> fishermans;
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        if (!file.exists()) {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
            return;
        }
        try {
            TypeReference<List<Fisherman>> typeRef = new TypeReference<>() {};
            fishermans = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Fisherman fisherman : fishermans) {
            System.out.println(fisherman.toString());
        }
    }
}
