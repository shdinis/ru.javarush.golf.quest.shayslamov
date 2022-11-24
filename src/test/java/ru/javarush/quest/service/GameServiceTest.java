package ru.javarush.quest.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;
import ru.javarush.quest.repository.imp.InMemoryAnswerRepository;
import ru.javarush.quest.repository.imp.InMemoryQuestionRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Mock
    GameService gameService;

    @Test
    void findAnswersByIdQuestion() {
        List<Long> list = Arrays.asList(1L, 2L);
//        Mockito.when(gameService.findAnswersByIdQuestion(1L)).thenReturn(list);

//        assertEquals(list, gameService.findAnswersByIdQuestion(1L));
    }
}
