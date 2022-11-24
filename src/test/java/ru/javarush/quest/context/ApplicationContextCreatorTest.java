package ru.javarush.quest.context;


import org.junit.jupiter.api.Test;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.service.GameService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextCreatorTest {

    ApplicationContextCreator applicationContextCreator = new ApplicationContextCreator();

    @Test
    void getQuestionTextTest() {
        assertEquals("Ты потерял память.", applicationContextCreator.getQuestionText(1L));
    }

    @Test
    void getQuestionDefaultTextTest() {
        assertEquals("", applicationContextCreator.getQuestionText(Long.MAX_VALUE));
    }
    @Test
    void getQuestionBackgroundPictureTest() {
        assertEquals("background.jpg", applicationContextCreator.getQuestionBackgroundPicture(1L));
    }

    @Test
    void getQuestionBackgroundDefaultPictureTest() {
        assertEquals("", applicationContextCreator.getQuestionBackgroundPicture(Long.MAX_VALUE));
    }

    @Test
    void getAnswerListByIdQuestionTest() {
        List<Answer> expectedText = new ArrayList<>(Arrays.asList(new Answer("Принять вызов", 1L)));
        assertEquals(expectedText, applicationContextCreator.getAnswerListByIdQuestion(1L));
    }
}
