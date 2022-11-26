package com.breadhard.hexagonalspringexample.domain;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDomain {
    Customer getCustomerById(String id);
    List<Customer> getCustomersByName(String name);
    String createCustomer(Customer customer);
    void activateCustomer(String id);
    void deactivateCustomer(String id);
    void deleteCustomer(String id);
}
