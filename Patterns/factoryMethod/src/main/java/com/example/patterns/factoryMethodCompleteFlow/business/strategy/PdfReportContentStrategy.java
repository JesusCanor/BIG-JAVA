package com.example.patterns.factoryMethodCompleteFlow.business.strategy;

import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.List;

public interface PdfReportContentStrategy<T> {

    Class<T> getClase();
    ReportTypeEnum getType();
    void portada(Document document) throws DocumentException;
    PdfPTable tabla(List<T> objs);
    boolean conclusion(Document document) throws DocumentException;
}
