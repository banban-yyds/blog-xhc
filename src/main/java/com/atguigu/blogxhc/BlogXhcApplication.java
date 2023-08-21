package com.atguigu.blogxhc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BlogXhcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogXhcApplication.class, args);
    }

}
