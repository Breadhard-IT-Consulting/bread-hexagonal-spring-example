package com.breadhard.hexagonalspringexample.ports.input;

public interface CustomersServiceInputPort<T,K,R> {
    // Funciones de negocio por las que se accede al dominio
    T getCustomer(R id);
    T getCustomers(R name);
    T postCustomer(K customer);
    T patchCustomer(K customer);
}
