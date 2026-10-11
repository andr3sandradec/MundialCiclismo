package modelo;

public class Atleta {
    protected String nombre;
    protected int edad;
    protected String pais;

    public Atleta(String nombre, int edad, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getPais() { return pais; }

    @Override
    public String toString() {
        return "Atleta -> Nombre: " + nombre + " | Edad: " + edad + " | País: " + pais;
    }
}