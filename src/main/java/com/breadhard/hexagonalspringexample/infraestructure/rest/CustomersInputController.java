package com.breadhard.hexagonalspringexample.infraestructure.rest;

import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.domain.service.CustomerService;
import com.breadhard.hexagonalspringexample.infraestructure.rest.dto.CustomerDTO;
import com.breadhard.hexagonalspringexample.infraestructure.rest.dto.CustomerIdDTO;
import com.breadhard.hexagonalspringexample.infraestructure.rest.mapper.CustomersToDomainMapper;
import com.breadhard.hexagonalspringexample.ports.input.CustomersInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@Slf4j
@AllArgsConstructor
public class CustomersInputController implements CustomersInputPort<ResponseEntity,CustomerDTO,String> {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomersToDomainMapper customersToDomainMapper;
    @Override
    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        return customer == null ? ResponseEntity.noContent().build()
            : ResponseEntity.ok().body(customersToDomainMapper.toCustomerDTO(customer));
    }

    @Override
    @GetMapping("")
    public ResponseEntity getCustomers(@RequestParam String name) {
        List<Customer> customerList = customerService.findCustomersByName(name);
        return (customerList != null && !customerList.isEmpty()) ?
                ResponseEntity.ok().body(customersToDomainMapper.toCustomersDTO(customerList))
                    : ResponseEntity.noContent().build();
    }

    @Override
    @PostMapping("")
    public ResponseEntity postCustomer(@RequestBody CustomerDTO customer) {
        String customerId = customerService.createNewCustomer(customersToDomainMapper.fromCustomerDTO(customer));
        return (StringUtils.hasText(customerId)) ?
            ResponseEntity.ok().body(CustomerIdDTO.builder().id(customerId))
                : ResponseEntity.badRequest().build();
    }

    @Override
    @PatchMapping("")
    public ResponseEntity patchCustomer(CustomerDTO customer) {
        return ResponseEntity.ok().body(customer);
    }

}
