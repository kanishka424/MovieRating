package io.fluffy.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication//tells spring that this is an spring boot application
public class MovieCatalogServiceApplication {

	@Bean
	public RestTemplate getRestTempalte() {
		return  new RestTemplate();//this will be a singleton by default,will only run once
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
