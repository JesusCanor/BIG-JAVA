package com.example.patterns.factoryMethod;

import java.math.BigDecimal;

public class BurguerPortuguesa implements Burguer {
    @Override
    public BurguerDTO preparar() {
        return new BurguerDTO("Burguer Portuguesa", new BigDecimal(10));
    }
}
