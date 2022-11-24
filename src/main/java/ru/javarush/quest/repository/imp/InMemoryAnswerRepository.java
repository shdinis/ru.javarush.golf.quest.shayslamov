package ru.javarush.quest.repository.imp;

import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.repository.AnswerRepository;

import java.util.Map;

public class InMemoryAnswerRepository extends AbstractCrudRepository<Answer> implements AnswerRepository {

    public InMemoryAnswerRepository(Map<Long, Answer> idToEntity) {
        super(idToEntity);
    }
}
