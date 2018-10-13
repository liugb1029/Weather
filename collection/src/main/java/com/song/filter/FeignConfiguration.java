package com.song.filter;

import com.song.config.FeignBasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }

}
