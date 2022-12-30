
package com.hyundai.tiltheend_team.Filters;

import java.io.IOException;

import com.hyundai.tiltheend_team.dao.LoginDao;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter("/login/*") //모든것을 다 검열하겠다.
public class LoginFilter implements Filter{
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        HttpSession httpSession = httpServletRequest.getSession();
        // System.out.println(request.getRemoteHost());
        // System.out.println(request.getRemoteAddr());
        String uri = httpServletRequest.getRequestURI();
        if(uri.endsWith("logOutPageServlet")) {
            httpSession = httpServletRequest.getSession(false); // 존재하면 인스턴스화
                if(httpSession != null) {
                    httpSession.invalidate();// 없애는게 아니라 만료시킴
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}