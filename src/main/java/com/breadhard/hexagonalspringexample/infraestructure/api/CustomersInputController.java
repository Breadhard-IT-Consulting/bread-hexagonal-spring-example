package com.breadhard.hexagonalspringexample.infraestructure.api;

import com.breadhard.hexagonalspringexample.domain.CustomerDomain;
import com.breadhard.hexagonalspringexample.domain.model.Customer;
import com.breadhard.hexagonalspringexample.infraestructure.api.dto.CustomerDTO;
import com.breadhard.hexagonalspringexample.infraestructure.api.dto.CustomerIdDTO;
import com.breadhard.hexagonalspringexample.infraestructure.api.mapper.CustomersToDomainMapper;
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
public class CustomersInputController implements CustomersInputPort<ResponseEntity,CustomerDTO> {
    @Autowired
    private CustomerDomain customerDomain;
    @Autowired
    private CustomersToDomainMapper customersToDomainMapper;
    @Override
    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable String id) {
        Customer customer = customerDomain.getCustomerById(id);
        return customer == null ? ResponseEntity.noContent().build()
            : ResponseEntity.ok().body(customersToDomainMapper.toCustomerDTO(customer));
    }

    @Override
    @GetMapping("")
    public ResponseEntity getCustomers(@RequestParam String name) {
        List<Customer> customerList = customerDomain.getCustomersByName(name);
        return (customerList != null && !customerList.isEmpty()) ?
                ResponseEntity.ok().body(customersToDomainMapper.toCustomersDTO(customerList))
                    : ResponseEntity.noContent().build();
    }

    @Override
    @PostMapping("")
    public ResponseEntity postCustomer(@RequestBody CustomerDTO customer) {
        String customerId = customerDomain.createCustomer(customersToDomainMapper.fromCustomerDTO(customer));
        return (StringUtils.hasText(customerId)) ?
            ResponseEntity.ok().body(CustomerIdDTO.builder().id(customerId))
                : ResponseEntity.badRequest().build();
    }

    @Override
    @PatchMapping("")
    public ResponseEntity patchCustomer(CustomerDTO customer) {
        if (customer.getActive()) {
            customerDomain.activateCustomer(customer.getId());
        } else {
            customerDomain.deactivateCustomer(customer.getId());
        }
        return ResponseEntity.ok().body(customer);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        customerDomain.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
