package com.example.patterns.factoryMethodCompleteFlow.business.factory;

import com.example.patterns.factoryMethodCompleteFlow.business.factory.impl.PDFReportGenerator;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.PdfReportContentStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PDFFactory extends Reporte {
    private Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy;

    public PDFFactory(Set<PdfReportContentStrategy> types) {
        this.reportContentStrategy = new HashMap<>();
        types.forEach(type -> this.reportContentStrategy.put(type.getType(), type));
    }

    @Override
    public ReportGenerator crearReporte() {
        return new PDFReportGenerator(reportContentStrategy);
    }
}
