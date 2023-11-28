package com.example.patterns.strategyPattern.reports.strategies;

import com.example.patterns.strategyPattern.reports.IReport;
import com.example.patterns.strategyPattern.reports.ReportEnum;
import com.example.patterns.strategyPattern.reports.model.User;
import com.example.patterns.strategyPattern.reports.model.UserRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.lang.reflect.Field;
import java.util.List;

public class UserReportStrategy implements IReport {

    private final UserRepository userRepository;

    public UserReportStrategy(UserRepository userRepository) { this.userRepository = userRepository; }


    @Override
    public ReportEnum getReportType() { return ReportEnum.CLIENT; }

    @Override
    public void portada(Document document) throws DocumentException {
        Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 30, BaseColor.GREEN);
        Font authorFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.CYAN);

        Paragraph titleParagraph = new Paragraph("Reporte Usuarios", titleFont);

        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - titleFont.getSize());
        document.add(titleParagraph);

        document.newPage();
    }

    @Override
    public PdfPTable tabla() {
        var users = userRepository.findAll();
        var fields = users.get(0).getClass().getDeclaredFields();

        PdfPTable table = new PdfPTable(fields.length);

        addTableHeader(table, fields);
        addRows(table, users);

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

    private void addRows(PdfPTable table, List<User> users) {

        for (User user : users) {
            for (Field field : user.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                try {
                    Object value = field.get(user);
                    table.addCell(new PdfPCell(new Phrase(value.toString())));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean conclusion(Document document) throws DocumentException {
        Font conclusion = FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 10, BaseColor.ORANGE);

        Paragraph titleParagraph = new Paragraph("Esto es un ejemplo de párrafo");
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - conclusion.getSize());
        document.add(titleParagraph);

        return false;
    }
}
