package main;

import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

public class Main {

    public static void main(String[] args) {
        RegistroPrototipos registro = new RegistroPrototipos();

        // 1. Registrar dos personajes base (prototipos)
        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Poción de vida");
        registro.registrarPrototipo("Guerrero",
                new Personaje("Guerrero", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Poción de maná");
        registro.registrarPrototipo("Mago",
                new Personaje("Mago", "Mago", invMago));

        // 2. Clonar desde el registro (nunca con new)
        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        System.out.println("============================");
        System.out.println("     Estado inicial ");
        System.out.println("============================\n");
        System.out.println(registro.consultarPrototipo("Guerrero"));
        System.out.println(guerreroCopia);
        System.out.println(registro.consultarPrototipo("Mago"));
        System.out.println(magoCopia);

        // 3. Modificar el inventario de una copia
        guerreroCopia.getInventario().agregarItem("Escudo");

        System.out.println("\n======================================");
        System.out.println("Tras agregar 'Escudo' a Guerrero-Copia ");
        System.out.println("======================================\n");
        System.out.println("Prototipo: " + registro.consultarPrototipo("Guerrero"));
        System.out.println("Copia:     " + guerreroCopia);
        System.out.println("Mago original: " + registro.consultarPrototipo("Mago"));

        // 4. Prototipo inexistente
        System.out.println("\n======================================");
        System.out.println("      Prototipo inexistente ");
        System.out.println("======================================\n");
        Personaje arquero = registro.obtenerCopia("Arquero");
        System.out.println("Resultado: " + arquero);
    }
}
