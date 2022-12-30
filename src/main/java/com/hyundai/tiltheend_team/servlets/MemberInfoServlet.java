package com.hyundai.tiltheend_team.servlets;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.MemberList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/memberInfoServlet")
public class MemberInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberList memberList = new MemberList();

    }
}
