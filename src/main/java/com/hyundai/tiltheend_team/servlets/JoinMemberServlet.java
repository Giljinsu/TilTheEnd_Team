package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.InsertUsers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/joinMemberServlet")
public class JoinMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InsertUsers insertUsers = new InsertUsers();

        String name = (String)request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String identification_number = request.getParameter("identification_number"); // ex) 010 011
        String number = request.getParameter("number"); // 전화번호 나머지
        String email = request.getParameter("email");
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");

        System.out.println(name);

        insertUsers.insertUser(name, age, sex, identification_number, number, email, ID, PW);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
