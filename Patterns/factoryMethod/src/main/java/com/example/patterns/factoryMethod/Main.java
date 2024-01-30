package com.example.patterns.factoryMethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Main {

	public static void main(String[] args) {
		Restaurante restauranteEspañol = new ChefEspañol(); //El constructor?? de dónde sale??? TODO
		restauranteEspañol.ordenarBurguer();

		Restaurante resturantePortugues = new ChefPortuguesa();
		resturantePortugues.ordenarBurguer();

		Restaurante restauranteFrances = new ChefFrances();
		restauranteFrances.ordenarBurguer();
	}
}