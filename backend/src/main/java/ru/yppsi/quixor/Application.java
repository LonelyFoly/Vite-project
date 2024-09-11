package ru.yppsi.quixor;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@SecurityScheme(name = "Bearer Authentication",
        scheme = "bearer", bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/auth").allowedOrigins("http://localhost:5173");
                registry.addMapping("/registration").allowedOrigins("http://localhost:5173");
            }
        };
    }
}


