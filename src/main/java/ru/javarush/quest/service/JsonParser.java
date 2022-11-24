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

    public Map<Long, Question> parseQuestion(InputStream file) {

        Map<Long, Question> result;

        try {
            result = objectMapper.readValue(file, new TypeReference<HashMap<Long, Question>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse the file with questions for the quest");
        }
        return result;
    }

    public Map<Long, Answer> parseAnswer(InputStream file){
        Map<Long, Answer> result;

        try {
            result = objectMapper.readValue(file, new TypeReference<HashMap<Long, Answer>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse quest answer file");
        }
        return result;
    }
}
