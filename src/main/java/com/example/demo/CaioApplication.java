package com.example.demo;

import com.example.demo.config.property.AlgamoneyApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AlgamoneyApiProperty.class)
public class CaioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaioApplication.class, args);
	}


}
