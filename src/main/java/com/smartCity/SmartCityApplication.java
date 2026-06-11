package com.smartCity;

import com.smartCity.webApp.service.application.ApplicationService;
import com.smartCity.webApp.service.application.StorageProperties;
import com.smartCity.webApp.service.application.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SmartCityApplication{
	public static void main(String[] args) {
		SpringApplication.run(SmartCityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}

