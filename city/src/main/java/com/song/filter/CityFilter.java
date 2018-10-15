package com.song.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            if(req.getServletPath().startsWith("/actuator")){
                //logger.info("start.......... /actuator" + req.getServletPath());
                filterChain.doFilter(servletRequest, servletResponse);
            }else if(!StringUtils.isEmpty(token) && token.length() > 2){
                logger.info("pass...");
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                logger.error("please add token...");

                //ServletOutputStream out =  servletResponse.getOutputStream();
                servletResponse.getWriter().write("<h1 style='text-align:center'>401 Unauthorized</h1>");
                //out.write('1');
                //out.flush();
                //filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
