package ru.javarush.quest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<Long, Question> parseQuestion(String file) {

        Map<Long, Question> result;

        try {
            result = objectMapper.readValue(getFilePath(file), new TypeReference<HashMap<Long, Question>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<Long, Answer> parseAnswer(String file){
        Map<Long, Answer> result;

        try {
            result = objectMapper.readValue(getFilePath(file), new TypeReference<HashMap<Long, Answer>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public InputStream getFilePath(String file) {
        return JsonParser.class.getClassLoader().getResourceAsStream(file);
    }
}
