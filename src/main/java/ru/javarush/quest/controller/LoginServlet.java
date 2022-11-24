package ru.javarush.quest.controller;

import ru.javarush.quest.context.ApplicationContextCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.InetAddress;

@WebServlet(name = "LoginServlet", value = "/quest")
public class LoginServlet extends HttpServlet {

    private final ApplicationContextCreator applicationContextCreator = new ApplicationContextCreator();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession currentSession = request.getSession();
        Long nextQuestionId = getSelectedIndex(request, "click");

        if (nextQuestionId == 1) {
            long counter = getSelectedIndex(request, "counter");
            counter = counter + 1;
            currentSession.setAttribute("counter", counter);
        }

        currentSession.setAttribute("question", applicationContextCreator.getQuestionText(nextQuestionId));
        currentSession.setAttribute("backgroundPicture", applicationContextCreator.getQuestionBackgroundPicture(nextQuestionId));
        currentSession.setAttribute("answers", applicationContextCreator.getAnswerListByIdQuestion(nextQuestionId));

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
//
        if (name != null) {
            HttpSession currentSession = req.getSession(true);
            currentSession.setAttribute("name", name);
            currentSession.setAttribute("question", applicationContextCreator.getQuestionText(1L));
            currentSession.setAttribute("backgroundPicture", applicationContextCreator.getQuestionBackgroundPicture(1L));
            currentSession.setAttribute("answers", applicationContextCreator.getAnswerListByIdQuestion(1L));
            currentSession.setAttribute("sessionId", currentSession.getId());
            currentSession.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
            currentSession.setAttribute("counter", 0);
            getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private Long getSelectedIndex(HttpServletRequest request, String attribute) {
        String click = request.getParameter(attribute);
        boolean isNumeric = click.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(click) : 1L;
    }
}
