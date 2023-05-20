package com.cockroachdb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import jdk.javadoc.doclet.Doclet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {


    @Value("${neo.openapi.dev-url}")
    private String devUrl;

    @Value("${neo.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI muopenApi()
    {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server url for developement environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server url for production environment");

        Contact contact = new Contact();
        contact.setEmail("arbaaz.sayed@neosoftmail.com");
        contact.setName("Sayed Arbaaz");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                .title("Employee Management App")
                .version("1.0")
                .contact(contact)
                .description("API exposes endpoints to manage employees data")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer,prodServer));

    }

}
