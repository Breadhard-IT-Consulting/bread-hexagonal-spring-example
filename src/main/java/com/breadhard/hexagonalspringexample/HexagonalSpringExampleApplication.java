package com.breadhard.hexagonalspringexample;

import com.breadhard.hexagonalspringexample.infraestructure.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringBootConfiguration.class)
public class HexagonalSpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalSpringExampleApplication.class, args);
	}

}
