package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.hyundai.tiltheend_team.dao.JoinMember;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/joinMemberServlet")
public class JoinMemberServlet extends HttpServlet {
    boolean idnotDup = false;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JoinMember joinMember = new JoinMember();
        String isFinish = request.getParameter("isFinish");
        String ID = request.getParameter("ID");
        // response.sendRedirect("/joinMember.jsp");
        if(request.getParameter("idnotDup")!=null){
            idnotDup = Boolean.parseBoolean(request.getParameter("idnotDup")); 
        }
        
        RequestDispatcher requestDispatcher = null;        
        if(isFinish!=null&&!isFinish.equals("fin")) {
            if(ID != "") {
                int isTrue = joinMember.idCheck(ID);
                if(isTrue==1) {
                    //같다
                    request.setAttribute("isDup", "중복된 ID 입니다!");
                    idnotDup=false;
                } else {
                    //아니다
                    request.setAttribute("isDup", "사용 가능한 ID입니다!");
                    idnotDup=true;
                }
            } else {
                request.setAttribute("isDup", "값을 입력해주세요!");
                idnotDup=false;
            }
            requestDispatcher = request.getRequestDispatcher("/joinMember.jsp");
            requestDispatcher.forward(request, response);
        } else if(idnotDup) {
            // if(idnotDup) {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String sex = request.getParameter("sex");
            String identification_number = request.getParameter("identification_number"); // ex) 010 011
            String number = identification_number+"-"+request.getParameter("number"); // 전화번호 나머지
            String email = request.getParameter("email");
            ID = request.getParameter("ID");
            String PW = request.getParameter("PW");
    
            System.out.println(name);
    
            joinMember.insertUser(name, age, sex, identification_number, number, email, ID, PW);
            // requestDispatcher = request.getRequestDispatcher("/index.html");
            // requestDispatcher.forward(request, response);
            response.sendRedirect("/index.html");
            idnotDup = false;
        } else {
            if(isFinish!=null){
                request.setAttribute("isDup", "ID중복체크 해주세요!");
            }
            requestDispatcher = request.getRequestDispatcher("/joinMember.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
