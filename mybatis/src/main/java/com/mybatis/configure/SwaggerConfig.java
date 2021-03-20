package com.mybatis.configure;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket produceApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.mybatis.controller"))
//                .paths(paths())
//                .build();
//    }
//    // Describe your apis
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Hotel Management Rest APIs")
//                .description("This page lists all the rest apis for Hotel Management App.")
//                .version("1.0-SNAPSHOT")
//                .build();
//    }
//    // Only select apis that matches the given Predicates.
//    private Predicate<String> paths() {
//// Match all paths except /error
//        return Predicates.and(
//                PathSelectors.regex("/user.*"),
//                Predicates.not(PathSelectors.regex("/error.*"));
//    }

//    @Bean
//    public Docket swagger() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("Employee Management REST API")
                .contact(new Contact("Ramesh Fadatare", "www.javaguides.net", "ramesh24fadatare@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }



//    @Bean
//    public Docket postsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

//    private Predicate<String> postPaths() {
//        return regex("/user.*");
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("JavaInUser API")
//                .description("JavaINUser API reference for developers")
//                .termsOfServiceUrl("http://javainuse.com")
//                .contact("thienle2014@gmail.com").license("JavaInUse License")
//                .licenseUrl("thienle2014@gmail.com").version("1.0").build();
//    }
}
