package com.breadhard.hexagonalspringexample.infraestructure.repository.entity;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@SuperBuilder
public class CustomerMongoDBEntity extends Customer {
}
