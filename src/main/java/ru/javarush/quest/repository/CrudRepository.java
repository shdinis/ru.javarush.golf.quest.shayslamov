package ru.javarush.quest.repository;

import java.util.Optional;

public interface CrudRepository<E> {

    Optional<E> findById(Long id);
}
