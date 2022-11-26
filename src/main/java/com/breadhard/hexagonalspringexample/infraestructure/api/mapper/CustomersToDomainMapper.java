package com.breadhard.hexagonalspringexample.infraestructure.api.mapper;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.api.dto.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomersToDomainMapper {
    Customer fromCustomerDTO(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(Customer customer);
    List<Customer> fromCustomersDTO(List<CustomerDTO> customerDTOList);
    List<CustomerDTO> toCustomersDTO(List<Customer> customers);
}
