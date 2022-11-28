package com.breadhard.hexagonalspringexample.infraestructure.repository.impl;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.repository.CustomerMongoDBRepository;
import lombok.AllArgsConstructor;

import java.util.List;

public abstract class CustomerMongoDBRepositoryImpl implements CustomerMongoDBRepository {

    @Override
    public Customer getCustomerById(String customerId) {
        return this.findById(customerId).get();
    }

    @Override
    public String saveCustomer(Customer customer) {
        this.save(customer);
        return customer.getId();
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return this.findByName(name);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    public abstract List<Customer> findByName(String name);
}
