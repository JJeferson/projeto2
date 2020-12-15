package com.projeto2.projeto2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//O http pra acessar o swagger
	//http://localhost:8080/swagger-ui.html
		
	  @Bean
	  public Docket apiconfigDocs() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.projeto2.projeto2"))
	        .paths(PathSelectors.any())
	        .build();
	  }
}
