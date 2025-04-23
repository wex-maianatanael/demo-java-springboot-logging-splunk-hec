package com.splunk.hec.logging.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Splunk HEC Logging Demo API")
                        .version("1.0")
                        .description("Demo API to demonstrate how to send logs to SPLUNK via HEC."));
    }
}
