package com.example.patterns.factoryMethodCompleteFlow.business.service.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.service.DataProvider;
import com.example.patterns.factoryMethodCompleteFlow.domain.entity.Employee;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.persistance.EmployeeRepository;

import java.util.List;

public class EmployeeDataProvider implements DataProvider<Employee> {

    private final EmployeeRepository employeeRepository;

    public EmployeeDataProvider(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    @Override
    public ReportTypeEnum getType() { return ReportTypeEnum.EMPLOYEE; }

    @Override
    public List<Employee> getData() { return employeeRepository.findAll(); }
}
