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

@WebServlet(urlPatterns = "/menu/clientResultServlet")
public class ClientResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        SurveyResultDB surveyResultDB = new SurveyResultDB();

        ArrayList usersListWithSurvey = new ArrayList<>();
        try {
            usersListWithSurvey = surveyResultDB.getUsersListWithSurvey();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("usersListWithSurvey", usersListWithSurvey);

        String path = "/client_result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
