package ru.javarush.quest.context;

import lombok.EqualsAndHashCode;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.repository.AnswerRepository;
import ru.javarush.quest.repository.QuestionRepository;
import ru.javarush.quest.repository.imp.InMemoryAnswerRepository;
import ru.javarush.quest.repository.imp.InMemoryQuestionRepository;
import ru.javarush.quest.service.GameService;
import ru.javarush.quest.service.JsonParser;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode
public class ApplicationContextCreator {
    private final JsonParser jsonParser = new JsonParser();

    private final AnswerRepository answerRepository =
            new InMemoryAnswerRepository(jsonParser.parseAnswer(JsonParser.class.getClassLoader().getResourceAsStream("Answer.json")));
    private final QuestionRepository questionRepository =
            new InMemoryQuestionRepository(jsonParser.parseQuestion(JsonParser.class.getClassLoader().getResourceAsStream("Questions.json")));

    private final GameService gameService = new GameService(answerRepository, questionRepository);

    public GameService getGameService() {
        return gameService;
    }

    public String getQuestionText(Long id) {
        Optional<Question> byId = gameService.getQuestionRepository().findById(id);
        if (byId.isPresent()) {
            return byId.get().getQuestionText();
        }
        return "";
    }

    public String getQuestionBackgroundPicture(Long id) {
        Optional<Question> byId = gameService.getQuestionRepository().findById(id);
        if (byId.isPresent()) {
            return byId.get().getBackgroundPicture();
        }
        return "";
    }

    public List<Answer> getAnswerListByIdQuestion(Long id) {
        return gameService.findAnswersByIdQuestion(id);
    }
}
