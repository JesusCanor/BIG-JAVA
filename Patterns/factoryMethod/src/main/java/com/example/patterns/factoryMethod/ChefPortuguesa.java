package com.example.patterns.factoryMethod;

public class ChefPortuguesa extends Restaurante {
    @Override
    public Burguer crearBurguer() {
        return new BurguerPortuguesa();
    }
}
