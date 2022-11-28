package com.breadhard.hexagonalspringexample.domain.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
public class Customer {
    String id;
    String name;
    LocalDate birthDate;
    Boolean active;
}
