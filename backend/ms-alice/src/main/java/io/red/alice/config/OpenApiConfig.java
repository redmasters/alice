package io.red.alice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = createInfo();
        info.setContact(createContact());
        info.setLicense(createLicense());
        return new OpenAPI()
                .info(info)
                .servers(createServer());
    }

    private List<Server> createServer() {
        var serverLocalHost = new Server();
        serverLocalHost.setUrl("http://localhost:8081/swagger-ui.html");
        serverLocalHost.setDescription("Local Host");
        return Arrays.asList(serverLocalHost);
    }

    private Info createInfo() {
        var info = new Info();
        info.setTitle("MS ALICE ESTOQUE");
        info.setDescription("Micro servico responsavel pelo estoque do sistema Alice");
        info.setVersion("v1");
        return info;
    }

    private Contact createContact() {
        var contato = new Contact();
        contato.setName("@redmasters");
        contato.setEmail("github.com/redmasters");
        contato.setUrl("github.com/redmasters");
        return contato;
    }

    private License createLicense() {
        var licenca = new License();
        licenca.setName("Copyright (C) Alice  - Todos os direitos reservados ");
        licenca.setUrl("https://alice.io.com");
        return licenca;
    }
}
