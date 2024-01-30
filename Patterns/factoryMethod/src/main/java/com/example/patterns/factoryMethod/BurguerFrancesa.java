package com.example.patterns.factoryMethod;

import java.math.BigDecimal;

public class BurguerFrancesa implements Burguer {
    @Override
    public BurguerDTO preparar() {
        return new BurguerDTO("Burguer Francesa", new BigDecimal(15));
    }
}
