package io.management.patient.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    private static final String CODENAME = "TokenInterceptor";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("Inside {}#addInterceptors", CODENAME);
        // Apply the token validation interceptor to your controllers
        registry
                .addInterceptor(tokenInterceptor)
                .addPathPatterns("/users/**")
                .order(Ordered.HIGHEST_PRECEDENCE);
    }
}