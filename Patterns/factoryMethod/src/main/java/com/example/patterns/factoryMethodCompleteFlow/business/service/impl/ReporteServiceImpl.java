package com.example.patterns.factoryMethodCompleteFlow.business.service.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.factory.ExcelFactory;
import com.example.patterns.factoryMethodCompleteFlow.business.factory.PDFFactory;
import com.example.patterns.factoryMethodCompleteFlow.business.factory.ReportGenerator;
import com.example.patterns.factoryMethodCompleteFlow.business.factory.Reporte;
import com.example.patterns.factoryMethodCompleteFlow.business.service.DataProvider;
import com.example.patterns.factoryMethodCompleteFlow.business.service.ReporteService;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.ExcelReportContentStrategy;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.PdfReportContentStrategy;
import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReporteServiceImpl implements ReporteService {

    private Map<ReportTypeEnum, DataProvider<?>> dataProviders;
    private Map<ReportFormatEnum, ReportGenerator> reportGenerators;
    private Set<PdfReportContentStrategy> typesPdf;
    private Set<ExcelReportContentStrategy> typesExcel;

    public ReporteServiceImpl(Set<DataProvider<?>> types,
                              Set<ReportGenerator> formats,
                              Set<PdfReportContentStrategy> typesPdf,
                              Set<ExcelReportContentStrategy> typesExcel) {
        this.typesPdf = typesPdf;
        this.typesExcel = typesExcel;
        this.dataProviders = new HashMap<>();
        this.reportGenerators = new HashMap<>();
        types.forEach(type -> this.dataProviders.put(type.getType(), type));
        formats.forEach(format -> this.reportGenerators.put(format.getType(), format));
    }

    @Override
    public ReportData execute(ReportFormatEnum reportFormatEnum, ReportTypeEnum reportTypeEnum) throws DocumentException, IOException {
        List<?> data = dataProviders.get(reportTypeEnum).getData();

        Reporte reporte;
        switch(reportFormatEnum) {
            case PDF -> reporte = new PDFFactory(typesPdf);
            case EXCEL -> reporte = new ExcelFactory(typesExcel);
            default -> throw new IllegalArgumentException("");
        }

        return reporte.generarReporte(reportTypeEnum, data);
    }
}
