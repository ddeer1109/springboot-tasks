package com.codecool.springboot_tasks.filter;

import com.codecool.spingboot_tasks.request_counter.RequestCounterApplication;
import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    RequestCountStatsService requestService;

    @Override
    @Autowired
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("Hello Filter");
        filterChain.doFilter(request, servletResponse);
        System.out.println("Bye, from Filter");

    }
}
