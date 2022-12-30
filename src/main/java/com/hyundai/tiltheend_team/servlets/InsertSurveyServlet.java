package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.InsertSurvey;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertSurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InsertSurvey insertSurvey = new InsertSurvey();

        RequestDispatcher requestDispatcher = null;

        requestDispatcher = request.getRequestDispatcher("/joinMember.jsp");
        requestDispatcher.forward(request, response);
    }
}
