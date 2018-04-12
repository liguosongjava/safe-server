package com.safe.info.core.config;

import com.safe.info.core.filter.SecurityFilter;
import com.safe.info.core.filter.SessionTimeoutFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * web环境配置
 */
@Configuration
public class WebApplication {
    @Bean
    public FilterRegistrationBean sessionFilter(){
        FilterRegistrationBean fr = new FilterRegistrationBean(new SessionTimeoutFilter());
        fr.addUrlPatterns("/*");
        fr.setOrder(Ordered.HIGHEST_PRECEDENCE+80);
        return fr;
    }

//    @Bean
//    public FilterRegistrationBean securityFilter(){
//        FilterRegistrationBean fr = new FilterRegistrationBean(new SecurityFilter());
//        fr.addUrlPatterns("/*");
//        fr.setOrder(Ordered.HIGHEST_PRECEDENCE+79);
//        return fr;
//    }
}
