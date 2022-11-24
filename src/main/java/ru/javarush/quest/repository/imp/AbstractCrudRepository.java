package ru.javarush.quest.repository.imp;

import ru.javarush.quest.repository.CrudRepository;

import java.util.Map;
import java.util.Optional;

public class AbstractCrudRepository<E> implements CrudRepository<E> {

    protected final Map<Long, E> idToEntity;

    public AbstractCrudRepository(Map<Long, E> idToEntity) {
        this.idToEntity = idToEntity;
    }

    @Override
    public Optional<E> findById(Long id) {
        return Optional.ofNullable(idToEntity.get(id));
    }
}
