package ru.javarush.quest.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.AnswerRepository;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.entity.QuestionRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserJson {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public QuestionRepository getInstanceQuestionRepo(File file) {
        if (this.questionRepository == null) {
            this.questionRepository = readJsonQuestionFile(file);
        }
        return questionRepository;
    }

    public AnswerRepository getInstanceAnswerRepo(File file) {
        if (this.answerRepository == null) {
            this.answerRepository = readJsonAnswerFile(file);
        }
        return this.answerRepository;
    }

    private QuestionRepository readJsonQuestionFile(File file) {
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


    private AnswerRepository readJsonAnswerFile(File file) {
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
}
