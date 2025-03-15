package com.example.mdClone;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "MDClone microservice REST API Documentation",
				description = "MDClone REST API for credit card microservice project",
				version = "v1",
				contact = @Contact(
						name = "Yoram Nagawker",
						email = "yoramnag@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
public class MdCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdCloneApplication.class, args);
	}

}
