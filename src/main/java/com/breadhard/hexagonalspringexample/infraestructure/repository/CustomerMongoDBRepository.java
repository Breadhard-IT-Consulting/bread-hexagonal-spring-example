package com.breadhard.hexagonalspringexample.infraestructure.repository;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.ports.output.CustomersOutputPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class CustomerMongoDBRepository implements CustomersOutputPort<Customer, Customer>, MongoRepository<Customer, String> {
}
