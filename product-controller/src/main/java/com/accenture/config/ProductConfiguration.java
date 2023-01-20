package com.accenture.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    @Bean
    OpenAPI productConfigApi(){
        return new OpenAPI()
        .info(new Info()
                .description("Multi Module Microservice for product management.")
                .title("Product Management")
                .version("1.0.0")
                .license(new License().name("Apache 2.0").url("accenture.com")))
                .externalDocs(new ExternalDocumentation().description("external documentation"));
    }
}
