package com.breadhard.hexagonalspringexample.domain.service.impl;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.domain.service.CustomerService;
import com.breadhard.hexagonalspringexample.ports.output.CustomersOutputPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Data
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomersOutputPort customersOutputPort;
    @Override
    public String createNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(String id) {
        return null;
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return null;
    }

    @Override
    public void activateCustomer(String id) {

    }

    @Override
    public void deactivateCustomer(String id) {

    }
}
