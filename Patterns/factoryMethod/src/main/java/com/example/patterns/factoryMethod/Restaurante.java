package com.example.patterns.factoryMethod;

public abstract class Restaurante {

    public void ordenarBurguer() {
        Burguer burguer = crearBurguer();
        var burguerDTO = burguer.preparar();
        guardarRegistroCreacion(burguerDTO);

        //Lógica de negocio concreta. Ejemplo: delivery, cliente qué pide, pago...
    }

    public abstract Burguer crearBurguer(); //No se conoce como se va a crear, por eso está abierto a extensión, y cerrado a modificación

    private void guardarRegistroCreacion(BurguerDTO dto) { System.out.println("Guardamos " +dto); }

    private void encontrarDireccion(BurguerDTO dto) { System.out.println("Buscando direccion " +dto); }
}
