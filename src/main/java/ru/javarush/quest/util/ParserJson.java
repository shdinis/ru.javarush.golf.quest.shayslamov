package ru.javarush.quest.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.quest.entity.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ParserJson {

    private static ParserJson parserJson = new ParserJson();
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    private UserRepository userRepository;

private ParserJson(){

}

public static ParserJson getInstance(){
    if (parserJson==null){
        parserJson = new ParserJson();
    }
    return  parserJson;
}
    public QuestionRepository getInstanceQuestionRepo(InputStream file) {
        if (this.questionRepository == null) {
            this.questionRepository = readJsonQuestionFile(file);
        }
        return questionRepository;
    }

    public AnswerRepository getInstanceAnswerRepo(InputStream file) {
        if (this.answerRepository == null) {
            this.answerRepository = readJsonAnswerFile(file);
        }
        return this.answerRepository;
    }

    public UserRepository getInstanceUserRepository(InputStream file){
    if (this.userRepository==null){
        this.userRepository = readJsonUserFile(file);
    }
    return this.userRepository;
    }

    private QuestionRepository readJsonQuestionFile(InputStream file) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> initialQuestionFromJson;
        try {
            initialQuestionFromJson = objectMapper.readValue(file, new TypeReference<ArrayList<Question>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<Long, Question> result = new HashMap<>();
        for (Question question : initialQuestionFromJson) {
            result.put(question.getId(), question);
        }
        return new QuestionRepository(result);
    }

    private AnswerRepository readJsonAnswerFile(InputStream file) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Answer> initialAnswerFromJson;
        try {
            initialAnswerFromJson = objectMapper.readValue(file, new TypeReference<ArrayList<Answer>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<Long, Answer> result = new HashMap<>();
        for (Answer answer : initialAnswerFromJson) {
            result.put(answer.getId(), answer);
        }
        return new AnswerRepository(result);
    }

    private UserRepository readJsonUserFile(InputStream file) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> initialUserFromJson;
        try {
            initialUserFromJson = objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            Map<Long,User> result = new HashMap<>();
        for (User user : initialUserFromJson) {
            result.put(user.getId(), user);
        }
        return new UserRepository(result);
    }

    public void updateUserFromJsonFile(User user) {

    }
}
