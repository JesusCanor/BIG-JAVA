package com.example.patterns.factoryMethodCompleteFlow.implementation;

import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportFormatEnum;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.business.service.ReporteService;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reportService;

    public ReporteController(ReporteService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generar(@RequestParam ReportFormatEnum reportFormatEnum,
                                          @RequestParam ReportTypeEnum reportType) throws DocumentException, IOException {

        var reportData = reportService.execute(reportFormatEnum, reportType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(reportData.getMediaType());
        headers.setContentDispositionFormData("filename", reportData.getFileName());

        return new ResponseEntity<>(reportData.getData(), headers, HttpStatus.OK);
    }
}
