
package com.hyundai.tiltheend_team.Filters;

import java.io.IOException;

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


@WebFilter("/menu/*") //모든것을 다 검열하겠다.
public class CommonFilter implements Filter{
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        HttpSession httpSession = httpServletRequest.getSession();
        String userId = (String)httpSession.getAttribute("userId");
        if(userId == null) {
            httpServletResponse.sendRedirect("/logpage.jsp");
        } else{
            chain.doFilter(request, response);

        }
        // System.out.println(request.getRemoteHost());
        // System.out.println(request.getRemoteAddr());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}