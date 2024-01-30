package com.example.patterns.factoryMethodCompleteFlow.business.service;

import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface ReporteService {

    ReportData execute(ReportFormatEnum reportFormatEnum, ReportTypeEnum reportTypeEnum) throws DocumentException, IOException;
}
