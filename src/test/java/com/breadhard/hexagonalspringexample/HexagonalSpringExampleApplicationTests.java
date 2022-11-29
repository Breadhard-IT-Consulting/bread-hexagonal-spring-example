package com.breadhard.hexagonalspringexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.MongoDBContainer;

import java.io.File;

@SpringBootTest
@Slf4j
class HexagonalSpringExampleApplicationTests {
	static MongoDBContainer MONGO_DB_CONTAINER;
	public static DockerComposeContainer TEST_CONTAINERS_SERVICE;
			;
	@BeforeAll
	static void beforeClass() throws Exception {
		log.info("Start containers");
		TEST_CONTAINERS_SERVICE = new DockerComposeContainer(
				new File("src/test/resources/docker-compose-mongodb.yaml"));
		TEST_CONTAINERS_SERVICE.start();
		log.info("Containers started");

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

}
