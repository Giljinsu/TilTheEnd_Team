package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hyundai.tiltheend_team.dao.MemberList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/memberListServlet")
public class MemberListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberList memberList = new MemberList();
        ArrayList<HashMap> member = null;

        try {
            member = memberList.getMemberList();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("member", member);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("member_list.jsp");
        requestDispatcher.forward(request, response);
    }
}
