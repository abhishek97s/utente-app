package com.deuexsolutions.utente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UtenteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtenteAppApplication.class, args);
	}

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	      .build()
	      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Utente App")
				.description("User API for deuex solutions which can be utilized for profile level actions for an User.")
				.version("v1")
				.license("Utente 1.0")
				.licenseUrl("xyz.com")
				.contact(new springfox.documentation.service.Contact("Utente", "xyz.com", "abc"))
				.termsOfServiceUrl("http://xyz.com")
				.build();
	}
}
