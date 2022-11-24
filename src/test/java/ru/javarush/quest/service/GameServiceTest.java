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


    GameService gameService;

    @Test
    void findAnswersByIdQuestion() {
        Answer answer = new Answer("Ага",1L);
        List<Answer> expectedAnswerList = Arrays.asList(answer);

        Map<Long, Question> actualQuestionMap = new HashMap<>();
        actualQuestionMap.put(1L, new Question("Ты потерял память.", Arrays.asList(1L), "background.jpg"));
        QuestionRepository questionRepository = new InMemoryQuestionRepository(actualQuestionMap);
        Map<Long, Answer> actualAnswerMap = new HashMap<>();
        actualAnswerMap.put(1L, new Answer("Ага", 1L));
        AnswerRepository answerRepository = new InMemoryAnswerRepository(actualAnswerMap);
        gameService = new GameService(answerRepository, questionRepository);
        gameService.findAnswersByIdQuestion(1L);

        assertEquals(expectedAnswerList, gameService.findAnswersByIdQuestion(1L));
    }
}
