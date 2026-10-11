package modelo;

public class Competidor extends Atleta {
    private int ranking; // Puntos en el mundial
    private double estatura;
    private double peso;

    public Competidor(String nombre, int edad, String pais, int ranking, double estatura, double peso) {
        super(nombre, edad, pais);
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }

    public int getRanking() { return ranking; }

    // === SOBRECARGA 1 (Overload) ===
    public void actualizarRanking(int puntosObtenidos) {
        this.ranking += puntosObtenidos;
    }

    // === SOBRECARGA 2 (Overload) con Estructura Anidada ===
    public void actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        if (ganoMedalla) {
            // Estructura anidada (if-else dentro de un if)
            if (puntosObtenidos > 50) {
                this.ranking += (puntosObtenidos + 20); // Bonificación extra
            } else {
                this.ranking += (puntosObtenidos + 10); // Bonificación normal
            }
        } else {
            this.ranking += puntosObtenidos;
        }
    }

    // === SOBREESCRITURA (Override) ===
    @Override
    public String toString() {
        // Concatenando con super.toString() como exige el documento
        return super.toString() + "\n   └-> Ranking/Puntos: " + ranking + " | Estatura: " + estatura + "m | Peso: " + peso + "kg";
    }
}