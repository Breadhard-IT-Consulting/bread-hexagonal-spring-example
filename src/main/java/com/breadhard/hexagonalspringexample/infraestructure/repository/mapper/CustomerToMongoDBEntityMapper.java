package com.breadhard.hexagonalspringexample.infraestructure.repository.mapper;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.repository.entity.CustomerMongoDBEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerToMongoDBEntityMapper {
    public CustomerMongoDBEntity fromCustomer(Customer customer);
    public Customer toCustomer(CustomerMongoDBEntity customer);
}
