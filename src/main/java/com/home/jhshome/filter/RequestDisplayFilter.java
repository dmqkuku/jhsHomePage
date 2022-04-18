package com.home.jhshome.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class RequestDisplayFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("|||||||||||||||Filter Start||||||||=======");
        System.out.println("|||||||||||||||||||||||||||||||||||" + ((HttpServletRequest)request).getRequestURI());
        System.out.println("|||||||||||||||||||||||||||||||||||" + ((HttpServletRequest) request).getMethod());
        System.out.println("|||||||||||||||Filter End||||||||||-------");
        chain.doFilter(request, response);
    }
}
