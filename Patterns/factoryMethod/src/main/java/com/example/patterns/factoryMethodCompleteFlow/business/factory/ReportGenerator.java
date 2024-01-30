package com.example.patterns.factoryMethodCompleteFlow.business.factory;

import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public interface ReportGenerator {
    ReportFormatEnum getType();
    ReportData generateReport(ReportTypeEnum type, List<?> data) throws DocumentException, IOException;
}