package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hyundai.tiltheend_team.dao.SurveyPageDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/surveyPageServlet")
public class SurveyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SurveyPageDB surveyPageDB = new SurveyPageDB();
        ArrayList<HashMap> answer = null;
        HashMap<String, Object> question = null;

        try {
            question = surveyPageDB.getQuestion();
            answer = surveyPageDB.getAnswersList();

            System.out.println(question.get("QUESTION_ID"));
            System.out.println(question.get("QUESTION"));
            System.out.println(question.get("ORDERS"));

            answer = surveyPageDB.getAnswersList();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < answer.size(); i++) {
            HashMap<String, Object> answers_list = answer.get(i);
            System.out.println(answers_list.get("ORDERS"));
            System.out.println(answers_list.get("ANSWER"));
        }

        request.setAttribute("question", question);
        request.setAttribute("answer", answer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("surveyPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
