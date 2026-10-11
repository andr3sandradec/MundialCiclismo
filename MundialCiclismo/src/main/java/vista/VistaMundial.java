package vista;

import java.util.Scanner;

public class VistaMundial {
    private Scanner scanner;

    public VistaMundial() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int mostrarMenu() {
        System.out.println("\n=== MUNDIAL DE CICLISMO DE PISTA (CALI) ===");
        System.out.println("1. Registrar nuevo competidor");
        System.out.println("2. Actualizar ranking de un competidor");
        System.out.println("3. Mostrar todos los competidores");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    public double pedirDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }
}