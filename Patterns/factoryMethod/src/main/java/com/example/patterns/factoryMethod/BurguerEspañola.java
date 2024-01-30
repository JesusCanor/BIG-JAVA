package com.example.patterns.factoryMethod;

import java.math.BigDecimal;

public class BurguerEspañola implements Burguer {
    @Override
    public BurguerDTO preparar() {
        return new BurguerDTO("Burguer española", new BigDecimal.valueOf(12.50));
    }
}
