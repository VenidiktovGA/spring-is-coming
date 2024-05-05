package ru.venidiktov.springiscoming.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        var contact = new Contact();
        contact.setEmail("venidiktovga@gmail.com");
        contact.setName("Venidiktov G.A");

        var info = new Info()
                .title("\"Жележный банк\" API")
                .version("0.0.1")
                .contact(contact)
                .description("В мире игры престолов \"Железный банк\" может определить кому жить а кому умереть!");

        return new OpenAPI().info(info);
    }
}
