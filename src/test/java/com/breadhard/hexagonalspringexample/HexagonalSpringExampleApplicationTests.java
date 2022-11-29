package com.breadhard.hexagonalspringexample;

import com.breadhard.hexagonalspringexample.infraestructure.rest.CustomersServiceInputController;
import com.breadhard.hexagonalspringexample.infraestructure.rest.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.MongoDBContainer;

import java.io.File;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
@Getter @Setter
class HexagonalSpringExampleApplicationTests {
	static MongoDBContainer MONGO_DB_CONTAINER;
	public static DockerComposeContainer TEST_CONTAINERS_SERVICE;
	@Autowired
	private CustomersServiceInputController customersInputController;
	@BeforeAll
	static void beforeClass() throws Exception {
		log.info("Start containers");
		TEST_CONTAINERS_SERVICE = new DockerComposeContainer(
				new File("src/test/resources/docker-compose-mongodb.yaml"));
		TEST_CONTAINERS_SERVICE.start();
		log.info("Containers started");
		System.setProperty("MONGODB_URL_CONNECTION","localhost");

	}
	@AfterAll
	static void afterClass() throws Exception {
		log.info("Stop containers");
		TEST_CONTAINERS_SERVICE.stop();
		log.info("Containers stopped");
	}
	@Test
	void contextLoads() {
	}
	@Test
	void testInsertCustomer() {
		CustomerDTO customerDTO = CustomerDTO.builder().name("Pepe").birthDate(LocalDate.now())
				.id(new ObjectId().toString())
				.build();
		HttpEntity response = customersInputController.postCustomer(customerDTO);
		log.info("Respuesta: {}",response.getBody());
	}

}
