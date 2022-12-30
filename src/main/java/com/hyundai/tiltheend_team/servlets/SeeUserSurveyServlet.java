package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 설문확인 페이지
@WebServlet(urlPatterns = "/seeUserSurveyServlet")
public class SeeUserSurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        // SurveyResultDB surveyResultDB = new SurveyResultDB();
        // ArrayList entireStat = new ArrayList<>();
        // try {
        // entireStat = surveyResultDB.getEntireCount();
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // request.setAttribute("", ); //변수넘기기
        String path = "./see_user_survey.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
