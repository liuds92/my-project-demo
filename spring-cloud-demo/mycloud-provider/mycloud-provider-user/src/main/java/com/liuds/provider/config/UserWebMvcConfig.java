package com.liuds.provider.config;

import com.liuds.core.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: liuds
 * @date: 2018/11/28
 */
@Configuration
@Import(TokenInterceptor.class)
public class UserWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] apiTokenAddPathPatterns = {"/**"};
        String[] apiTokenExcludePathPatterns = {"/swagger-ui.html","/configuration/**","/v2/api-docs","/swagger-resources","/common/**"};
        registry.addInterceptor(tokenInterceptor).addPathPatterns(apiTokenAddPathPatterns)
                .excludePathPatterns(apiTokenExcludePathPatterns);
    }
}
