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
        ArrayList<HashMap> question = null;

        try {
            question = surveyPageDB.getQuestion();
            answer = surveyPageDB.getAnswersList();
            for (int i = 0; i < question.size(); i++) {
                HashMap<String, Object> questions_list = question.get(i);
                System.out.print(questions_list.get("QUESTION_ID"));
                System.out.print(questions_list.get("QUESTION"));
                System.out.println(questions_list.get("ORDERS"));
            }

            answer = surveyPageDB.getAnswersList();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < answer.size(); i++) {
            HashMap<String, Object> answers_list = answer.get(i);
            System.out.print(answers_list.get("ORDERS"));
            System.out.println(answers_list.get("ANSWER"));
        }

        request.setAttribute("question", question);
        request.setAttribute("answer", answer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("surveyPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
