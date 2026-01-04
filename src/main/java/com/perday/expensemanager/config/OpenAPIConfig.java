package com.perday.expensemanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Development server");

        Contact contact = new Contact();
        contact.setName("Expense Manager API");
        contact.setUrl("https://www.expensemanager.com");

        Info info = new Info()
                .title("Expense Manager API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage expenses.");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
