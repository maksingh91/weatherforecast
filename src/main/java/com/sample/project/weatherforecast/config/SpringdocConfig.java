package com.sample.project.weatherforecast.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI baseOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Weather Forecast Application").version("1.0.0").description("Base Path : http://localhost:8080").contact(new Contact().name("Mahaveer Singh Ratnoo").email("mratn91@gmail.com")));
    }
}
