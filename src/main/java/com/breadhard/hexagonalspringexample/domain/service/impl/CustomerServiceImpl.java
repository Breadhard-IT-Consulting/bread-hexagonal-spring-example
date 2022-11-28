package com.breadhard.hexagonalspringexample.domain.service.impl;

import com.breadhard.hexagonalspringexample.domain.agregator.CustomerAndOtherThingsAgrregator;
import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.domain.service.CustomerService;
import com.breadhard.hexagonalspringexample.ports.output.CustomersOutputPort;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomersOutputPort customersOutputPort;
    @Override
    public Customer getCustomerById(String id) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        return null;
    }

    @Override
    public String createCustomer(Customer customer) {
        return null;
    }

    @Override
    public void activateCustomer(String id) {

    }

    @Override
    public void deactivateCustomer(String id) {

    }

    @Override
    public void deleteCustomer(String id) {

    }
}
