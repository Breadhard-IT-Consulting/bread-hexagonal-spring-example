package com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb.mapper.CustomerToMongoDBEntityMapper;
import com.breadhard.hexagonalspringexample.ports.output.CustomersOutputPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Repository
public class CustomerOptputPortMongoDBImpl implements CustomersOutputPort<Optional<Customer>,String> {
    CustomerToMongoDBEntityMapper customerToMongoDBEntityMapper;
    @Autowired
    CustomerMongoDBRepository customerMongoDBRepository;

    @Override
    public Optional<Customer> getCustomerById(String customerId) {
        return customerToMongoDBEntityMapper.toOptionalOfCustomer(this.customerMongoDBRepository.findById(customerId));
    }

    @Override
    public String insertCustomer(Optional<Customer> customer) {
        if (customer.isEmpty()) return null;
        this.customerMongoDBRepository.insert(this.customerToMongoDBEntityMapper.fromCustomer(customer.get()));
        return customer.get().getId();
    }

    @Override
    public List<Optional<Customer>> getCustomersByName(String name) {
        return null;
    }

    @Override
    public void patchCustomer(Optional<Customer> customer) {

    }
}
