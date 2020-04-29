package com.ms.bootcamp.currencyinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.bootcamp.currencyinventory.model.Currency;
import com.ms.bootcamp.currencyinventory.repo.CurrencyRepository;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class CurrencyInventoryMsApplication {
	
	@Autowired
	CurrencyRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyInventoryMsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Currency p = new Currency(1, "GB", 1.20);
			repo.save(p);
			
			p = new Currency(2, "IN", 71.00);
			repo.save(p);
			
			p = new Currency(3, "CN", 10.20);
			repo.save(p);
			

		};
	}

}
