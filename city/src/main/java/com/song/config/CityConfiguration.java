package com.song.config;

import com.song.filter.CityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class CityConfiguration {

    @Bean
    public Filter cityFilter(){
        return new CityFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(cityFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("tokenFilter");
        filterRegistrationBean.setOrder(Integer.MAX_VALUE);
        return filterRegistrationBean;
    }
}
