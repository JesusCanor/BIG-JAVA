package com.example.patterns.factoryMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BurguerDTO {

    private String type;
    private BigDecimal price;
}
