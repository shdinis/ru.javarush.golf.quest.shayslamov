package ru.javarush.quest.entity;

import java.util.Map;

public class QuestionRepository {
    private final Map<Long, Question> idToQuestion;

    public QuestionRepository(Map<Long, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question findById(Long id) {
        return idToQuestion.get(id);
    }
}
