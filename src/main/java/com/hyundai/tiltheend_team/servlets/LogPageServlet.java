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
    HttpSession httpSessionID_Compare= null; // 세션을 비교하기 위함
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 한글세팅
        HttpSession httpSession = null; // 세션들 불러옴
        LoginDao loginDao = new LoginDao();
        String userId = "";
        String userPassword = "";
        String userName ="";
        result = 0;
    
        if(request.getParameter("userId")!=null&&request.getParameter("userPassword")!=null) {
            if(request.getParameter("userId")!=""&&request.getParameter("userPassword")!=""){
            userId = request.getParameter("userId");
            userPassword = request.getParameter("userPassword");
            userName = loginDao.getName(userId);
            result = loginDao.login(userId, userPassword);
        }
        }
        
        String path = null;
        if(result == 1) {
            //로그인 성공
            httpSession = request.getSession(false); // 존재하면 인스턴스화
            if(httpSession == null) {
                httpSession = request.getSession(); // 생성
                httpSession.setAttribute("userId", userId);
                httpSession.setAttribute("userPassword", userPassword);
                httpSession.setAttribute("userName", userName);
            } else if(httpSession != httpSessionID_Compare) {
                httpSession =request.getSession(); //생성
                httpSession.setAttribute("userId", userId); // httpSession에 저장
                httpSession.setAttribute("userPassword", userPassword);
                httpSession.setAttribute("userName", userName);
            }
            // 어드민 확인용
            if(loginDao.isAdmin(userId)) {
                path="/admin.jsp";
            } else{
                path = "/indexLogined.jsp";
            }
            result =0;
        } else {
            //로그인 실패
            // httpSession = request.getSession(false); // 존재하면 인스턴스화
            // if(httpSession != null) {
            //     httpSession.invalidate();// 없애는게 아니라 만료시킴
            // } 
            // 위의 세션 만료부분은 필터에서 처리함
                request.setAttribute("result", "아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다."+
                "입력하신 내용을 다시 확인해주세요. ");
            path = "/logpage.jsp";
        }

        // String path = "/logpage.jsp";
        httpSessionID_Compare = httpSession;// 세션 전값을 저장
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(req, resp);
    }
}
