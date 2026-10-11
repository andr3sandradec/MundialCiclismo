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

    // === MEJORA AÑADIDA: Cálculo de IMC (Índice de Masa Corporal) ===
    public double calcularIMC() {
        return this.peso / (this.estatura * this.estatura);
    }

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
        // Formateamos el IMC para que solo tenga 2 decimales
        String imcFormateado = String.format("%.2f", calcularIMC());
        
        // Concatenando con super.toString() e incluyendo el nuevo cálculo de IMC
        return super.toString() + "\n   └-> Puntos: " + ranking + " | Estatura: " + estatura + "m | Peso: " + peso + "kg | IMC Deportivo: " + imcFormateado;
    }
}