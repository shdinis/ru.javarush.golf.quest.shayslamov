package ru.javarush.quest.entity;

import java.util.Map;
import java.util.Optional;

public class AnswerRepository {
    private final Map<Long, Answer> idAnswerMap;

    public AnswerRepository(Map<Long, Answer> answerHashMap) {
        this.idAnswerMap = answerHashMap;
    }

    Optional<Answer> findById(Long id) {
        return Optional.ofNullable(idAnswerMap.get(id));
    }
}
