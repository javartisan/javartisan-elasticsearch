//package com.javartisan.springboot.javartisanspringboot;
//
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@Component
////@Order(-10001)
//@WebFilter(urlPatterns = "/*")
//public class LoggerRequestFilter implements Filter {
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//
//        ServletRequest requestWrapper = request;
//        if (request instanceof HttpServletRequest) {
//            requestWrapper = new LoggerRequestWapper((HttpServletRequest) request);
//        }
//
//        chain.doFilter(requestWrapper, response);
//    }
//
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//
//    }
//}
