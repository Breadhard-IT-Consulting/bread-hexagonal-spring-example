package com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb.mapper;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb.entity.CustomerMongoDBEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerToMongoDBEntityMapper {
    public CustomerMongoDBEntity fromCustomer(Customer customer);
    public Customer toCustomer(CustomerMongoDBEntity customer);
    List<Customer> toCustomers(List<CustomerMongoDBEntity> customers);
    List<CustomerMongoDBEntity> fromCustomers(List<Customer> customers);
    default Optional<Customer> toOptionalOfCustomer(Optional<CustomerMongoDBEntity> customerMongoDBEntity) {
        return customerMongoDBEntity.isEmpty() ? Optional.empty()
                : Optional.of(this.toCustomer(customerMongoDBEntity.get()));
    }
    default Optional<CustomerMongoDBEntity> fromOptionalOfCustomer(Optional<Customer> customer) {
        return customer.isEmpty() ? Optional.empty()
                : Optional.of(this.fromCustomer(customer.get()));
    }

}
