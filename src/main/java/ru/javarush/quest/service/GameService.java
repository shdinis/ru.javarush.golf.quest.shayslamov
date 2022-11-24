package ru.javarush.quest.service;

import lombok.Getter;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public GameService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public List<Answer> findAnswersByIdQuestion(Long id){
        Answer orElseAnswer = new Answer("Начать с начала",1L);
        Question orElseQuestion = new Question("Начать с начала?", null, "");
        List<Long> idAnswer = questionRepository.findById(id).orElse(orElseQuestion).getIdAnswer();
        List<Answer> result = new ArrayList<>();
        for (Long aLong : idAnswer) {
            result.add(answerRepository.findById(aLong).orElse(orElseAnswer));
        }
        return result;
    }
}
