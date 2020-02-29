package com.blog.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.cors.CorsConfiguration.ALL;

/**
 * CORS configuration
 */
@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins(ALL)
                .allowedMethods(ALL)
                .allowedHeaders(ALL)
                .allowCredentials(true);
    }

}