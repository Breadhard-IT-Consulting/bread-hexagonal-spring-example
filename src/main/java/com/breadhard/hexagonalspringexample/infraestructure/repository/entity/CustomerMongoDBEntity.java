package com.breadhard.hexagonalspringexample.infraestructure.repository.entity;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document
public class CustomerMongoDBEntity extends Customer {
}
