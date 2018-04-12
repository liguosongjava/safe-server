package com.safe.info.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.safe.info.core.settings.ServerSettings;
import com.safe.info.core.util.SystemUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * 启动主类
 */
@Configuration
@ComponentScan(basePackages ="com.safe.info.core")
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
@MapperScan("com.safe.info.core.mapper")
@EnableConfigurationProperties({ ServerSettings.class })
public class SafeServerLauncher extends SpringBootServletInitializer{
    public static void main(String[] args) {
        if (SystemUtil.isWindows()) {
            System.setProperty("env", "dev");
        }
        final SpringApplication springApplication = new SpringApplication(
                SafeServerLauncher.class);
        springApplication.addListeners(new ApplicationPidFileWriter("PID.txt"));
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.listeners();
        return application.sources(SafeServerLauncher.class);
    }

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.getUrlMappings().clear();
//        registration.addUrlMappings("*.do");
//        registration.addUrlMappings("*.json");
//        return registration;
//    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
                container.addErrorPages(error404Page);
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
                container.addErrorPages(error500Page);
            }
        };
    }

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("SAFESESSIONID");//cookies名称
        cookieSerializer.setCookieMaxAge(3600);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

}
