package com.example.patterns.factoryMethodCompleteFlow.persistance;

import com.example.patterns.factoryMethodCompleteFlow.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
