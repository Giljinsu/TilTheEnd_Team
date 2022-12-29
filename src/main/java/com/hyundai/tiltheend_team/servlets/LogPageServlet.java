package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.LoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login/logPageServlet")
public class LogPageServlet extends HttpServlet {
    int result = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
    //     HttpSession httpSession = null; // 세션들 불러옴
    //     LoginDao loginDao = new LoginDao();
    //     String userId = "";
    //     String userPassword = "";

    //     if(request.getParameter("userId")!=""&&request.getParameter("userPassword")!=""){
    //     userId = request.getParameter("userId");
    //     userPassword = request.getParameter("userPassword");
    //     result = loginDao.login(userId, userPassword);
    // }
        
    //     String path = null;
    //     if(result == 1) {
    //         //로그인 성공
    //         httpSession = request.getSession(false); // 존재하면 인스턴스화
    //         if(httpSession == null) {
    //             httpSession = request.getSession(); // 생성
    //             httpSession.setAttribute("userId", userId);
    //             httpSession.setAttribute("userPassword", userPassword);
    //             path = "/logpage.jsp";
    //         }
    //         result =0;

    //     } else {
    //         //로그인 실패
    //         httpSession = request.getSession(false); // 존재하면 인스턴스화
    //         if(httpSession != null) {
    //             httpSession.invalidate();// 만료
    //         }
    //         path = "/logpage.jsp";
    //     }
        String path = "/logpage.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
