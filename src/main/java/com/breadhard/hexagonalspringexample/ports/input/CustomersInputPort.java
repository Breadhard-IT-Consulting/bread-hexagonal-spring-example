package com.breadhard.hexagonalspringexample.ports.input;

import java.util.List;

public interface CustomersInputPort<T,K,R> {
    T getCustomer(R id);
    T getCustomers(R name);
    T postCustomer(K customer);
    T patchCustomer(K customer);
    T deleteCustomer(R id);
}
