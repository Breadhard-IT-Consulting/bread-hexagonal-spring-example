package com.breadhard.hexagonalspringexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Slf4j
class HexagonalSpringExampleApplicationTests {
	static MongoDBContainer MONGO_DB_CONTAINER;
	@BeforeAll
	static void beforeClass() throws Exception {
		log.info("Start containers");
		MONGO_DB_CONTAINER = new MongoDBContainer(DockerImageName.parse("mongo:latest"))
/*				.withEnv("MONGO_INITDB_DATABASE", "mytestdb")
				.withEnv("MONGO_INITDB_ROOT_USERNAME", "anyuser")
				.withEnv("MONGO_INITDB_ROOT_PASSWORD", "whatever")*/
				.withExposedPorts(27017);
		MONGO_DB_CONTAINER.start();
		log.info("Containers started");

	}
	@AfterAll
	static void afterClass() throws Exception {
		log.info("Stop containers");
		MONGO_DB_CONTAINER.stop();
		log.info("Containers stopped");
	}
	@Test
	void contextLoads() {
	}

}
