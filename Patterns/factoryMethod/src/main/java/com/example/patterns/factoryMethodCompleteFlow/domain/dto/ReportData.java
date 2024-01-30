package com.example.patterns.factoryMethodCompleteFlow.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;

@AllArgsConstructor
@Getter
public class ReportData {

    private byte[] data;
    private MediaType mediaType;
    private String fileName;
}
