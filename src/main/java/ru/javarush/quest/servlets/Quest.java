package ru.javarush.quest.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "quest", value = "/quest")
public class Quest extends HttpServlet {

    private Integer countForGame;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();
        int nextQuestionId = getSelectedIndex(request);

        currentSession.setAttribute("questionId", nextQuestionId);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }


    private int getSelectedIndex(HttpServletRequest request) {
        String click = request.getParameter("click");
        boolean isNumeric = click.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(click) : 0;
    }
}
