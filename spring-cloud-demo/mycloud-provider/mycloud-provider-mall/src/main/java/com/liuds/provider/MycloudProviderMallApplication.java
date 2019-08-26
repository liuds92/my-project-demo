package com.liuds.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MycloudProviderMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycloudProviderMallApplication.class, args);
	}

}
