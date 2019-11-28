package com.example.demo2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo2.entity.Country;
import com.example.demo2.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Demo2Application {

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Demo2Application.class, args);
		Demo2Application application = context.getBean(Demo2Application.class);
		application.start();
		context.close();
	}

	private void start() {
		Country country = countryService.getByCode("FR");
		log.info("-> {}", country);
	}

	@PostConstruct
	private void init() {
		countryService.saveFromCsv("src/main/resources/countries.csv");
	}
}
