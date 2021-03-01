package io.fluffy.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication//tells spring that this is an spring boot application
@EnableEurekaClient
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced//how to consume micro service in Eureka
	public RestTemplate getRestTempalte() {
		return  new RestTemplate();//this will be a singleton by default,will only run once
	}

//	@Bean
//	public WebClient.Builder getWebClientBuilder() {
//		return  WebClient.builder();//this will be a singleton by default,will only run once
//	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
