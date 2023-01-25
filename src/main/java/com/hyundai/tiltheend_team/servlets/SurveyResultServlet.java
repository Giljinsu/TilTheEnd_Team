package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hyundai.tiltheend_team.dao.SurveyResultDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 용범: 전체통계
@WebServlet(urlPatterns = "/menu/surveyResultServlet")
public class SurveyResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        SurveyResultDB surveyResultDB = new SurveyResultDB();
        ArrayList entireStat = new ArrayList<>();
        try {
            entireStat = surveyResultDB.getEntireCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("entireStat", entireStat);
        String path = "/survey_result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
