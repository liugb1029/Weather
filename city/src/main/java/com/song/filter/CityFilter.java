package com.song.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CityFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("check request hander token....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String token =  req.getHeader("Authorization");
            if(!StringUtils.isEmpty(token) && token.length() > 2){
                logger.info("pass...");

                System.out.println("pass");
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                logger.error("please add token...");
                return;
            }
        }

    }

    @Override
    public void destroy() {

    }
}
