package com.example.patterns.strategyPattern.reports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    Long id;
    String name;
    byte age;
    byte timeWithCompany;
}
