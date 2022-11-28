package com.breadhard.hexagonalspringexample.infraestructure.repository;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.ports.output.CustomersOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableMongoRepositories
public interface CustomerMongoDBRepository extends CustomersOutputPort<Customer, Customer,String>, MongoRepository<Customer, String> {
}
