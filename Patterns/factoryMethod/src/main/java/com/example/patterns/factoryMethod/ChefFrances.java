package com.example.patterns.factoryMethod;

public class ChefFrances extends Restaurante{
    @Override
    public Burguer crearBurguer() {
        return new BurguerFrancesa();
    }
}
