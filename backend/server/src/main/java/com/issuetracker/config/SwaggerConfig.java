package com.issuetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Issue Tracker API")
                .description("Spring API made by Noel and Pyro")
                .license("Apache License Version 2.0")
                .version("0.1")
                .build();

        Set<String> responseContentType = new HashSet<>();
        responseContentType.add("application/json;charset=UTF-8");

        // http://localhost:8080/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("issuetracker")
                .produces(responseContentType)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.issuetracker"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
