package com.proyecto.servicios.onboarding.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiOnboardingConfig {

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI onboardingOpenAPI() {
        final String schemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("Onboarding Clientes Personas Fisicas API")
                        .description("API REST para registro, consulta y gestion de clientes bancarios")
                        .version("1.0.0")
                        .contact(new Contact().name("Cristian Oropeza").email("oropezacristian40@gmail.com"))
                        .license(new License().name("MIT")))
                .addSecurityItem(new SecurityRequirement().addList(schemeName))
                .components(new Components().addSecuritySchemes(schemeName,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("JWT opcional por ahora. Header: Authorization: Bearer <token>")));
    }
}
