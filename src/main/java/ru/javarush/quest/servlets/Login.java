package ru.javarush.quest.servlets;

import ru.javarush.quest.entity.AnswerRepository;
import ru.javarush.quest.entity.QuestionRepository;
import ru.javarush.quest.entity.User;
import ru.javarush.quest.util.ParserJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Optional;


@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession currentSession = request.getSession(true);
//        ParserJson quest = ParserJson.getInstance();
//
//        QuestionRepository questionRepo = quest.getInstanceQuestionRepo(Login.class.getClassLoader().getResourceAsStream("Questions.json"));
//        AnswerRepository answerRepo = quest.getInstanceAnswerRepo(Login.class.getClassLoader().getResourceAsStream("Answer.json"));
//
//        currentSession.setAttribute("questions", questionRepo);
//        currentSession.setAttribute("answers", answerRepo);
//        currentSession.setAttribute("questionId", 1L);
//
//        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession currentSession = req.getSession();
        ParserJson quest = ParserJson.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null & password != null) {
            Optional<User> user= quest.getInstanceUserRepository(Login.class.getClassLoader().getResourceAsStream("Users.json"))
                    .findById(login,password);
        if (user.isPresent()){
            QuestionRepository questionRepo = quest.getInstanceQuestionRepo(Login.class.getClassLoader().getResourceAsStream("Questions.json"));
            AnswerRepository answerRepo = quest.getInstanceAnswerRepo(Login.class.getClassLoader().getResourceAsStream("Answer.json"));
            HttpSession currentSession = req.getSession(true);
            currentSession.setAttribute("user", user.get());
            currentSession.setAttribute("questions", questionRepo);
            currentSession.setAttribute("answers", answerRepo);
            currentSession.setAttribute("questionId", 1L);
        }
        }




        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

}
