package com.example.patterns.factoryMethod;

public class ChefEspañol extends Restaurante{
    @Override
    public Burguer crearBurguer() {
        return new BurguerEspañola();
    }
}
