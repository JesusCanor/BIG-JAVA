package com.example.patterns.factoryMethodCompleteFlow.business.factory.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.factory.ReportGenerator;
import com.example.patterns.factoryMethodCompleteFlow.domain.dto.ReportData;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.business.strategy.PdfReportContentStrategy;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PDFReportGenerator implements ReportGenerator {

    private final Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy;

    @Autowired
    public PDFReportGenerator(Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy) {
        this.reportContentStrategy = reportContentStrategy;
    }

    @Override
    public ReportFormatEnum getType() {
        return ReportFormatEnum.PDF;
    }

    @Override
    public ReportData generateReport(ReportTypeEnum type, List<?> data) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        PdfReportContentStrategy<?> strategy = this.reportContentStrategy.get(type);
        addContentUsingStrategy(strategy, document, data);

        document.close();
        return new ReportData(outputStream.toByteArray(),
                MediaType.APPLICATION_PDF,
                "report.pdf");
    }

    private <T> void addContentUsingStrategy(PdfReportContentStrategy<T> strategy, Document document, List<?> data) throws DocumentException {
        if (!data.isEmpty() && strategy.getClase().isInstance(data.get(0))) {
            strategy.portada(document);
            document.add(strategy.tabla((List<T>) data));
            document.newPage();

            var isComplex = strategy.conclusion(document);

            if (isComplex) {
                document.newPage();
                Font titleComplex = FontFactory.getFont(FontFactory.COURIER, 100, BaseColor.ORANGE);

                Paragraph titleParagraph = new Paragraph("Esta es una lógica pra generar un PDF", titleComplex);
                titleParagraph.setAlignment(Element.ALIGN_CENTER);
                titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - titleComplex.getSize());
                document.add(titleParagraph);
            }
        } else {
            throw new IllegalArgumentException("Mismatched data type");
        }
    }
}
