package com.example.patterns.factoryMethodCompleteFlow.business.factory;

import com.example.patterns.factoryMethodCompleteFlow.business.factory.impl.ExcelReportGenerator;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.ExcelReportContentStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExcelFactory extends Reporte {

    private Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy;

    public ExcelFactory(Set<ExcelReportContentStrategy> types) {
        this.reportContentStrategy = new HashMap<>();
        types.forEach(type -> this.reportContentStrategy.put(type.getType(), type));
    }
    @Override
    public ReportGenerator crearReporte() {
        return new ExcelReportGenerator(reportContentStrategy);
    }
}