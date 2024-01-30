package com.example.patterns.factoryMethodCompleteFlow.business.service;

import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;

import java.util.List;

public interface DataProvider<T> {
    ReportTypeEnum getType();
    List<T> getData();
}
