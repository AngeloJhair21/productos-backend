package com.UTP.productos.config;


import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        //los metodos tanto que ponemos como tambien los options que hace internamente
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        //Permites que la petición traiga cualquier tipo de información extra en la "cabecera"
                        .allowedHeaders("*");
            }
        };
    }
}
