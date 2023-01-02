package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.RemoveSurveyDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/menu/removeSurveyPageServlet")
public class RemoveSurveyPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
        HttpSession httpSession = request.getSession();
        RemoveSurveyDao removeSurveyDao = new RemoveSurveyDao();
        String userId = (String)httpSession.getAttribute("userId");
        String password = "";
        String path = "";
        boolean isRemoved = false;
        if(request.getParameter("password")!=null) {
            password = request.getParameter("password");
            isRemoved = removeSurveyDao.removeSurvey(userId,password);

        }
            if(isRemoved) {
                //삭제 완료시
                System.out.println("삭제");
                response.sendRedirect("/indexLogined.jsp");
            } else {
                path = "/removeSurveyPage.jsp";
                if(password != "") {
                    request.setAttribute("result", "틀린 비밀번호입니다.");
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }
    }
}
