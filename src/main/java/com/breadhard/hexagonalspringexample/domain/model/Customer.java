package com.breadhard.hexagonalspringexample.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Getter
@Setter
public class Customer {
    String id;
    String name;
    LocalDate birthDate;
    Boolean active;
}
