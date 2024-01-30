package com.example.patterns.factoryMethodCompleteFlow.business.strategy.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.strategy.PdfReportContentStrategy;
import com.example.patterns.factoryMethodCompleteFlow.domain.entity.Client;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ClientStrategyPdfReport implements PdfReportContentStrategy<Client> {


    @Override
    public Class<Client> getClase() { return Client.class; }

    @Override
    public ReportTypeEnum getType() { return ReportTypeEnum.CLIENT; }

    @Override
    public void portada(Document document) throws DocumentException {

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
        Font authorFont = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);

        Paragraph titleParagraph = new Paragraph("REPORTE DE CLIENTES", titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - titleFont.getSize());
        document.add(titleParagraph);

        Paragraph authorParagraph = new Paragraph( new StringBuilder().append("Generador por ").append("Jesús.").toString(), authorFont);
        authorParagraph.setAlignment(Element.ALIGN_CENTER);
        authorParagraph.setSpacingBefore(50);
        document.add(authorParagraph);

        document.newPage();
    }

    @Override
    public PdfPTable tabla(List<Client> objs) {
        var fields = objs.get(0).getClass().getDeclaredFields();

        PdfPTable table = new PdfPTable(fields.length);

        addTableHeader(table, fields);
        addRows(table, objs);

        return table;
    }

    private void addTableHeader(PdfPTable table, Field[] fields) {

        for (Field field: fields) {
            field.setAccessible(true);
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(field.getName()));
            table.addCell(header);
        }
    }

    public void addRows(PdfPTable table, List<Client> clients) {
        for (Client client : clients) {
            for (Field field : client.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                try {
                    Object value = field.get(client); //TODO TOUNDERSTAND
                    PdfPCell cell;

                    if (field.getName().equals("age")) {
                        Byte age = (Byte) value;
                        if (age > 25) {
                            cell = new PdfPCell(new Phrase(value.toString()));
                            cell.setBackgroundColor(BaseColor.GREEN);
                        } else {
                            cell = new PdfPCell(new Phrase(value.toString()));
                            cell.setBackgroundColor(BaseColor.RED);
                        }
                    } else {
                        cell = new PdfPCell(new Phrase(value.toString()));
                    }

                    table.addCell(cell);
                } catch (IllegalAccessException e) { e.printStackTrace(); }
            }
        }
    }

    @Override
    public boolean conclusion(Document document) throws DocumentException {
        Font conclusion = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 60, BaseColor.BLACK);

        Paragraph titleParagraph = new Paragraph("ÚLTIMO PÁRRAFO DE CONCLUSIÓN", conclusion);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - conclusion.getSize());
        document.add(titleParagraph);

        return true;
    }
}
