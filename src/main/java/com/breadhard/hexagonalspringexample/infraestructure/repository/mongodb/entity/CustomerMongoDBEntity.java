package com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb.entity;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("C_CUSTOMERS")
@SuperBuilder
public class CustomerMongoDBEntity extends Customer {
}
