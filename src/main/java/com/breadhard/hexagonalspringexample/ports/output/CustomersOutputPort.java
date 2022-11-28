package com.breadhard.hexagonalspringexample.ports.output;

import java.util.List;

public interface CustomersOutputPort<K,T,R> {
    K getCustomerById(R customerId);
    R saveCustomer(K customer);
    List<K> findCustomerByName(R name);
    void updateCustomer(K customer);
}
