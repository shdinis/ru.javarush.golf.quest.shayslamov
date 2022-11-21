package ru.javarush.quest.entity;

import java.util.Map;
import java.util.Optional;

public class UserRepository {
//    private final UserRepository USER_REPOSITORY = new UserRepository();
    private final Map<Long, User> idToUser;

//    public static UserRepository getInstance() {
//        return USER_REPOSITORY;
//    }
    public UserRepository(Map<Long, User> idToUser) {
        this.idToUser = idToUser;
    }

    public Optional<User> findById(String login, String password) {
        return idToUser.values().stream()
                .filter(user -> user.getName().equals(login))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
