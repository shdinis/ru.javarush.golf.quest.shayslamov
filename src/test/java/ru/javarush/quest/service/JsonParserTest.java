package ru.javarush.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.javarush.quest.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    JsonParser jsonParser;
    ObjectMapper mapper = new ObjectMapper();
    InputStream filePath;
    Map<Long, Question> expectedMap;


    @Test
    void parseQuestion() {
        expectedMap = new HashMap<>();
        expectedMap.put(1L, new Question("Ты потерял память.", Arrays.asList(1L), "background.jpg"));
        filePath = JsonParserTest.class.getClassLoader().getResourceAsStream("Questions.json");
        Mockito.doReturn(filePath).when(jsonParser.getFilePath("Questions.json"));
        Map<Long, Question> result = new HashMap<>();
        result = jsonParser.parseQuestion("Questions.json");
        assertEquals(expectedMap, result);
    }

    @Test
    void parseAnswer() {
    }
}
