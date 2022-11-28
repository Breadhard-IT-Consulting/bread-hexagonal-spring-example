package com.breadhard.hexagonalspringexample.ports.input;

public interface CustomersInputPort<T,K,R> {
    T getCustomer(R id);
    T getCustomers(R name);
    T postCustomer(K customer);
    T patchCustomer(K customer);
}
