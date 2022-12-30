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

// 설문확인 페이지
@WebServlet(urlPatterns = "/menu/seeUserSurveyServlet")
public class SeeUserSurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅

        // 내가 누군지 먼저 파악해야함. session을 통해서 userId를 파악해야 함. - 로그인이 해결되어야 가능.
        // 일단 userId='UID01' 이라고 가정하고 페이지 불러오자.

        SurveyResultDB surveyResultDB = new SurveyResultDB();
        ArrayList entireStat = new ArrayList<>();

        String userId = "UID01";
        // 이 user가 설문을 작성했는지 부터 파악하기
        try {
            if (surveyResultDB.hasSurvey(userId)) { // user가 설문을 작성했다면. 설문내용을 보여주는 페이지로 이동하기
                entireStat = surveyResultDB.getEntireCount(); // 전체통계 페이지에서 활용한 함수 재활용하기. 질문리스트를 뽑기에 편해서.
                // user가 답변한 내용을 불러오는 함수가 필요함.
                ArrayList userAnswerList = surveyResultDB.getSurveyById(userId);

                request.setAttribute("entireStat", entireStat); // 변수넘기기
                request.setAttribute("userId", userId); // userId 넘기기
                request.setAttribute("userAnswerList", userAnswerList); // userId 넘기기
                // 설문내용 페이지로 이동하기
                String path = "/see_user_survey.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            } else { // survey가 없으면
                // pop up 창으로 설문을 아직 작성안하셨습니다! 알려주기
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
