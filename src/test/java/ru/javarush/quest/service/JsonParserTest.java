package ru.javarush.quest.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    JsonParser jsonParser = new JsonParser();


    @Test
    void parseQuestionTest() {
        Map<Long, Question> expectedMap = new HashMap<>();
        expectedMap.put(1L, new Question("Ты потерял память.", Arrays.asList(1L), "background.jpg"));

        Map<Long, Question> result;
        result = jsonParser.parseQuestion(JsonParserTest.class.getClassLoader().getResourceAsStream("Questions.json"));
        assertEquals(expectedMap, result);
    }

    @Test
    void checkIfQuestionParserThrowsExceptionMessageTest(){
        Throwable throwable =assertThrows(RuntimeException.class,
                () -> jsonParser.parseQuestion(JsonParserTest.class.getClassLoader().getResourceAsStream("Answer.json")));
        assertEquals("Failed to parse the file with questions for the quest",throwable.getMessage());
    }

    @Test
    void parseAnswerTest() {
        Map<Long,Answer> expectedMap = new HashMap<>();
        expectedMap.put(1L, new Answer("Принять вызов", 1L));

        Map<Long, Answer> result;
        result = jsonParser.parseAnswer(JsonParser.class.getClassLoader().getResourceAsStream("Answer.json"));
        assertEquals(expectedMap, result);
    }

    @Test
    void checkIfAnswerParserThrowsExceptionMessageTest(){
        Throwable throwable = assertThrows(RuntimeException.class,
                () -> jsonParser.parseAnswer(JsonParserTest.class.getClassLoader().getResourceAsStream("Questions.json")));
        assertEquals("Failed to parse quest answer file",throwable.getMessage());
    }
}
