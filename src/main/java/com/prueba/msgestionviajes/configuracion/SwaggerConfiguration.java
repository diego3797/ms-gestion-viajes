package com.prueba.msgestionviajes.configuracion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Springweb",
        version = "1.0",
        description = "swagger"
))
public class SwaggerConfiguration {

}
