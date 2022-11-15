package ru.javarush.quest.entity;

import java.util.Map;
import java.util.Optional;

public class QuestionRepository {
    private final Map<Long, Question> idToQuestion;

    public QuestionRepository(Map<Long, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    Optional<Question> findById(Long id) {
        return Optional.ofNullable(idToQuestion.get(id));
    }
}
