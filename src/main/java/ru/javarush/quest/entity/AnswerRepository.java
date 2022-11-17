package ru.javarush.quest.entity;

import java.util.Map;

public class AnswerRepository {
    private final Map<Long, Answer> idAnswerMap;

    public AnswerRepository(Map<Long, Answer> answerHashMap) {
        this.idAnswerMap = answerHashMap;
    }

    public Answer findById(Long id) {
        return idAnswerMap.get(id);
    }
}
