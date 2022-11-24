package ru.javarush.quest.repository.imp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCrudRepositoryTest {

    @Test
    void getFindById() {
        Map<Long, String> stringMap = new HashMap<>();
        stringMap.put(1L, "Hello");
        AbstractCrudRepository<String> example = new AbstractCrudRepository<>(stringMap);
        assertEquals("Hello", example.findById(1L).orElse(""));
    }
}
