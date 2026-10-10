package prototype;

import model.Inventario;

public class Personaje {

    private String nombre;
    private String clase;
    private Inventario inventario;

    public Personaje(String nombre, String clase, Inventario inventario) {
        this.nombre = nombre;
        this.clase = clase;
        this.inventario = inventario;
    }

    private Personaje(Personaje otro) {
        this.nombre = otro.nombre;
        this.clase = otro.clase;
        this.inventario = otro.inventario.copiar();
    }

    public Personaje clonar() {
        return new Personaje(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return "Personaje{nombre='" + nombre + "', clase='" + clase
                + "', inventario=" + inventario + "}";
    }
}
