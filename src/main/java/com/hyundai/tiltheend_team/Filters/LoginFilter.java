
// package com.hyundai.tiltheend_team.Filters;

// import java.io.IOException;

// import com.hyundai.tiltheend_team.dao.LoginDao;

// import jakarta.servlet.Filter;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.FilterConfig;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;


// @WebFilter("/login/*") //로그인을 검열하겠다.
// public class LoginFilter implements Filter{
//     @Override
//     public void destroy() {
//     }

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         LoginDao loginDao = new LoginDao();
//         HttpSession httpSession = null; // 세션들 불러옴
//         HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//         HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//         String userId = "";
//         String userPassword = "";
//         int result = 0;
//         if(httpServletRequest.getParameter("userId")!=null&&httpServletRequest.getParameter("userPassword")!=null){
//         userId = httpServletRequest.getParameter("userId");
//         userPassword = httpServletRequest.getParameter("userPassword");
//         result = loginDao.login(userId, userPassword);
//     }
        
//         String path = null;
//         if(result == 1) {
//             //로그인 성공
//             httpSession = httpServletRequest.getSession(false); // 존재하면 인스턴스화
//             if(httpSession == null) {
//                 httpSession = httpServletRequest.getSession(); // 생성
//                 httpSession.setAttribute("userId", userId);
//                 httpSession.setAttribute("userPassword", userPassword);
//                 path = "/index.html";
//             }
//             result =0;

//         } else {
//             //로그인 실패
//             httpSession = httpServletRequest.getSession(false); // 존재하면 인스턴스화
//             if(httpSession != null) {
//                 httpSession.invalidate();// 만료
//             }
//             path = "/login/logPageServlet";

//         }


//         // System.out.println(request.getRemoteHost());
//         // System.out.println(request.getRemoteAddr());
//         chain.doFilter(request, response);
//     }

//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//     }
// }