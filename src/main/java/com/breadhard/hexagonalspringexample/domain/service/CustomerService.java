package com.breadhard.hexagonalspringexample.domain.service;

import com.breadhard.hexagonalspringexample.domain.model.Customer;

import java.util.List;
public interface CustomerService {
    String createNewCustomer(Customer customer);
    Customer getCustomerById(String id);
    List<Customer> findCustomersByName(String name);
    void activateCustomer(String id);
    void deactivateCustomer(String id);
}
