package ru.javarush.quest.servlets;

import lombok.Getter;
import ru.javarush.quest.entity.Answer;
import ru.javarush.quest.entity.AnswerRepository;
import ru.javarush.quest.entity.Question;
import ru.javarush.quest.entity.QuestionRepository;
import ru.javarush.quest.util.ParserJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession currentSession = request.getSession(true);
        String contextPath = request.getContextPath();
        ParserJson quest = new ParserJson();

        File fileAnswerRepo = new File("F:\\javarush\\projects\\quest\\ru.javarush.quest.shayslamov\\src\\main\\resources\\Answer.json");
        File fileQuestionRepo = new File("F:\\javarush\\projects\\quest\\ru.javarush.quest.shayslamov\\src\\main\\resources\\Questions.json");

        QuestionRepository questionRepo = quest.getInstanceQuestionRepo(fileQuestionRepo);
        AnswerRepository answerRepo = quest.getInstanceAnswerRepo(fileAnswerRepo);

        Question firstQuestion = questionRepo.findById(1L);


        currentSession.setAttribute("questions", questionRepo);
        currentSession.setAttribute("answers", answerRepo);
        currentSession.setAttribute("firstQuestion",firstQuestion);
        currentSession.setAttribute("questionId", 1L);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }

}