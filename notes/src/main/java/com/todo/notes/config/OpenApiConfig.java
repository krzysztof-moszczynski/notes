package com.todo.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    OpenAPI OpenAPI() {
        return new OpenAPI() 
            .info(new Info()
            .title("Notes app")
            .description("Simple todo app")
            .version("v1.0")
            );
        
    }
}
