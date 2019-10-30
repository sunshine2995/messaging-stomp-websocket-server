package com.xinming90.messagingstompwebsocketserver;


import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class SimpleCorsFilter implements Filter {

    private static final Logger logger = getLogger(SimpleCorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;

        rsp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        rsp.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, rsp);
    }
}
