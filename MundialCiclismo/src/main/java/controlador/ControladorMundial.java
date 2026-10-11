package controlador;

import java.util.ArrayList;
import modelo.Competidor;
import vista.VistaMundial;

public class ControladorMundial {
    private VistaMundial vista;
    private ArrayList<Competidor> listaCompetidores;

    public ControladorMundial(VistaMundial vista) {
        this.vista = vista;
        this.listaCompetidores = new ArrayList<>();
    }

    public void iniciar() {
        int opcion = 0;
        do {
            try {
                opcion = vista.mostrarMenu();
                switch (opcion) {
                    case 1: registrar(); break;
                    case 2: actualizar(); break;
                    case 3: listar(); break;
                    case 4: vista.mostrarMensaje("Saliendo del sistema..."); break;
                    default: vista.mostrarMensaje("Opción inválida.");
                }
            } catch (Exception e) {
                vista.mostrarMensaje("Entrada inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void registrar() {
        vista.mostrarMensaje("\n--- REGISTRAR ATLETA ---");
        String nombre = vista.pedirTexto("Nombre: ");
        int edad = vista.pedirEntero("Edad: ");
        String pais = vista.pedirTexto("País: ");
        int ranking = vista.pedirEntero("Puntos de ranking iniciales: ");
        double estatura = vista.pedirDouble("Estatura (en metros, ej 1.80): ");
        double peso = vista.pedirDouble("Peso (en kg, ej 75.5): ");

        listaCompetidores.add(new Competidor(nombre, edad, pais, ranking, estatura, peso));
        vista.mostrarMensaje("Competidor registrado exitosamente.");
    }

    private void actualizar() {
        if (listaCompetidores.isEmpty()) {
            vista.mostrarMensaje("No hay competidores registrados.");
            return;
        }

        String nombre = vista.pedirTexto("\nNombre del competidor a actualizar: ");
        Competidor encontrado = null;

        for (Competidor c : listaCompetidores) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = c;
                break;
            }
        }

        if (encontrado != null) {
            int puntos = vista.pedirEntero("Puntos obtenidos en la prueba: ");
            String respuesta = vista.pedirTexto("¿Ganó medalla? (si/no): ");
            
            // Uso de la Sobrecarga
            if (respuesta.equalsIgnoreCase("si")) {
                encontrado.actualizarRanking(puntos, true);
            } else {
                encontrado.actualizarRanking(puntos);
            }
            vista.mostrarMensaje("¡Puntaje actualizado! Nuevo ranking: " + encontrado.getRanking());
        } else {
            vista.mostrarMensaje("Competidor no encontrado.");
        }
    }

    private void listar() {
        vista.mostrarMensaje("\n--- LISTA DE COMPETIDORES ---");
        if (listaCompetidores.isEmpty()) {
            vista.mostrarMensaje("Lista vacía.");
        } else {
            for (Competidor c : listaCompetidores) {
                // Al imprimir, Java llama automáticamente al toString() sobreescrito
                vista.mostrarMensaje(c.toString());
            }
        }
    }
}