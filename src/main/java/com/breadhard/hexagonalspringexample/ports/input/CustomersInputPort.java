package com.breadhard.hexagonalspringexample.ports.input;

import java.util.List;

public interface CustomersInputPort<T,K> {
    T getCustomer(String id);
    T getCustomers(String name);
    T postCustomer(K customer);
    T patchCustomer(K customer);
    T deleteCustomer(String id);
}
