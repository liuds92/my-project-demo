package com.liuds.gateway;

import com.liuds.gateway.filter.AuthHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MycloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycloudGatewayApplication.class, args);
	}

	@Bean
	public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
		return new RequestTimeGatewayFilterFactory();
	}

	@Bean
	public AuthHeaderFilter tokenFilter(){
		return new AuthHeaderFilter();
	}
}
