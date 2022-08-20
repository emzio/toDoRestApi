package pl.coderslab.UdemyToDoRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class UdemyToDoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyToDoRestApiApplication.class, args);
	}

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
