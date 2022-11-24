package ru.javarush.quest.repository.imp;

import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.QuestionRepository;

import java.util.Map;

public class InMemoryQuestionRepository extends AbstractCrudRepository<Question> implements QuestionRepository {

    public InMemoryQuestionRepository(Map<Long, Question> idToEntity) {
        super(idToEntity);
    }
}
