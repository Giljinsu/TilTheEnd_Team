package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.core.annotation.SynthesizingMethodParameter;

import com.hyundai.tiltheend_team.dao.SurveyResultDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/menu/seeMemberList")
public class SeeMemberList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
        SurveyResultDB surveyResultDB = new SurveyResultDB();
        ArrayList userList = new ArrayList();
        try {
            userList = surveyResultDB.getUserList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("userList", userList);
        String path = "/seeMemberList.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
