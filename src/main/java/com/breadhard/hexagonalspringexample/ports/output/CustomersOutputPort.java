package com.breadhard.hexagonalspringexample.ports.output;

import java.util.List;

public interface CustomersOutputPort<K,R> {
    K getCustomerById(R customerId);
    R insertCustomer(K customer);
    List<K> getCustomersByName(R name);
    void patchCustomer(K customer);
}
