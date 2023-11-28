package com.example.patterns.strategyPattern.reports.strategies;

import com.example.patterns.strategyPattern.reports.IReport;
import com.example.patterns.strategyPattern.reports.ReportEnum;
import com.example.patterns.strategyPattern.reports.model.Employee;
import com.example.patterns.strategyPattern.reports.model.EmployeeRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class EmployeeStrategy implements IReport {

    private EmployeeRepository repository;

    public EmployeeStrategy(EmployeeRepository repository) { this.repository = repository; }

    @Override
    public ReportEnum getReportType() { return ReportEnum.EMPLOYEE; }

    @Override
    public void portada(Document document) throws DocumentException {
        Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 30, BaseColor.GREEN);
        Font authorFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.CYAN);

        Paragraph titleParagraph = new Paragraph("Reporte Empleados", titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - titleFont.getSize());

        Paragraph autorParagraph = new Paragraph(" Generador por: Jesús", authorFont);
        autorParagraph.setAlignment(Element.ALIGN_CENTER);
        autorParagraph.setSpacingBefore(50);
        document.add(autorParagraph);

        Paragraph resume = new Paragraph("Esto es una prueba", authorFont);
        autorParagraph.setAlignment(Element.ALIGN_CENTER);
        autorParagraph.setSpacingBefore(50);
        document.add(resume);

        document.newPage();
    }

    @Override
    public PdfPTable tabla() {
        var employees = repository.findAll();
        var fields = employees.get(0).getClass().getDeclaredFields();

        PdfPTable table = new PdfPTable(fields.length + 1);

        addTableHeader(table, fields);
        addRows(table, employees);

        return table;
    }

    public void addTableHeader(PdfPTable table, Field[] fields) {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.MAGENTA);
        header.setBorder(2);

        for(Field field: fields) {
            field.setAccessible(true);
            header.setPhrase(new Phrase(field.getName()));
            table.addCell(header);
        }

        header.setPhrase(new Phrase());

    }

    private void addRows(PdfPTable table, List<Employee> employees) {

        for (Employee employee: employees) {
            boolean isApplicableForGift = false;
            for (Field field : employees.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    PdfPCell cell;
                    new PdfPCell(new Phrase(value.toString()));
                    if (field.getName().equals("timeWithCompany")) {
                        Byte timeWithCompany = (Byte) value;
                        if (timeWithCompany > 10) {
                            isApplicableForGift = true;
                        }
                    }

                    table.addCell(new PdfPCell(new Phrase(value.toString())));
                } catch (IllegalAccessException e) { e.printStackTrace(); }
            }

            String message;
            if (isApplicableForGift) {
                message = "SI";
            } else {
                message = "NO";
            }

            table.addCell(new PdfPCell(new Phrase(message)));
        }
    }

    @Override
    public boolean conclusion(Document document) throws DocumentException {
        Font conclusion = FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 16, BaseColor.BLACK);

        Paragraph titleParagraph = new Paragraph("Aquí termina nuestro documento.");
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - conclusion.getSize());
        document.add(titleParagraph);

        return false;
    }
}
