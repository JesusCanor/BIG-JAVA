package com.example.patterns.factoryMethodCompleteFlow.business.factory.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.factory.ReportGenerator;
import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.ExcelReportContentStrategy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelReportGenerator implements ReportGenerator {

    private final Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy;

    @Autowired
    public ExcelReportGenerator(Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy) {
        this.reportContentStrategy = reportContentStrategy;
    }

    @Autowired
    public ReportFormatEnum getType() {
        return ReportFormatEnum.EXCEL;
    }

    @Override
    public ReportData generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook();

        ExcelReportContentStrategy<?> strategy = this.reportContentStrategy.get(reportTypeEnum);
        addContentUsingStrategy(strategy, workbook, data);

        workbook.write(outputStream);
        workbook.close();
        return new ReportData(outputStream.toByteArray(),
                MediaType.parseMediaType("application/vnd.ms-excel"),
                "report.xlsx");
    }

    @SuppressWarnings("unchecked")
    private <T> void addContentUsingStrategy(ExcelReportContentStrategy<T> strategy, XSSFWorkbook workbook, List<?> data) { //TODO <T> void
        if (!data.isEmpty() && strategy.getClase().isInstance(data.get(0))) {
            XSSFSheet sheet = workbook.createSheet("Report");
            strategy.addExcelContent(sheet, (List<T>) data);
        } else {
            throw new IllegalArgumentException("Mismatched data type");
        }
    }
}
