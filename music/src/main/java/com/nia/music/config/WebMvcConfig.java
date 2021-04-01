package com.nia.music.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *解决跨越问题
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域的地址
                .allowedOrigins("http://localhost:8080")//允许跨域的网站
                .allowedMethods("*")//允许跨域的方法
                .allowCredentials(true);//访问是否需要验证
    }
}
