package com.hungta.security.springsecurityexample.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

/**
 * @author HUNGTA on 01/01/18 - 1:39 PM
 * @project spring-security-example
 */
@Component
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init::Called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Principal userPrincipal = request.getUserPrincipal();
        System.out.println("userPrincipal " + userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy::called");
    }
}
