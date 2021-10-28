package com.mmierzwa.foodbook.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket SwaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("foodbookSwag")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mmierzwa.foodbook"))
                .paths(PathSelectors.any())
                .build();
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Demo with Swagger")
//                .description("Spring Demo with Swagger")
//                .contact(new Contact("Michał Mierzwa",
//                        "https://mmierzwa.com",
//                        "poczta.michau@gmail.com"))
//                .license("License name here")
//                .licenseUrl("URL to license")
//                .version("1.0.1")
//                .build();
//    }
}