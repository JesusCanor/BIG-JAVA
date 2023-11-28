package com.example.patterns.strategyPattern;


import com.example.patterns.strategyPattern.reports.ReportEnum;
import com.example.patterns.strategyPattern.reports.ReportFactory;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private ReportFactory reportFactory;

    public ReportController(ReportFactory reportFactory) { this.reportFactory = reportFactory; }

    @GetMapping("/generatePdf")
    public ResponseEntity<byte[]> generarPdf(@RequestParam ReportEnum reportEnum) throws DocumentException, IOException {
        byte[] pdfBytes = reportFactory.generateReport(reportEnum);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "report.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
