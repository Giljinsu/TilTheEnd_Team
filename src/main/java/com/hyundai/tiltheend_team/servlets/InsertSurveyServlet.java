package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.InsertSurvey;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/menu/insertSurvey")
public class InsertSurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        request.getParameter("Q1");
        String ID = (String) httpSession.getAttribute("userId");

        InsertSurvey insertSurvey = new InsertSurvey();

        insertSurvey.isDuplicate(ID);

        for (int i = 1; i < 7; i++) {
            String question = "Q" + i;
            String answer = request.getParameter("Q" + i);
            insertSurvey.insertSurvey(ID, question, answer);
        }

        response.sendRedirect("/indexLogined.jsp");
        // RequestDispatcher requestDispatcher = null;
        // requestDispatcher = request.getRequestDispatcher("index.html");
        // requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
