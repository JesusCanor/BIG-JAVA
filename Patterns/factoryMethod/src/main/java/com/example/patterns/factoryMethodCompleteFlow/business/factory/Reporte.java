package com.example.patterns.factoryMethodCompleteFlow.business.factory;

import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class Reporte {

    public ReportData generarReporte(ReportTypeEnum type, List<?> data) throws DocumentException, IOException {
        ReportGenerator reportGenerator = crearReporte();
        var reporte = reportGenerator.generateReport(type, data);
        saveFileOnCloud(reporte);
        return reporte;
    }

    private void saveFileOnCloud(ReportData data) {
        System.out.println("Respaldando en cloud el archivo de tipo " + crearReporte().getType() + Arrays.toString(data.getData()));
    }

    public abstract ReportGenerator crearReporte();
}
