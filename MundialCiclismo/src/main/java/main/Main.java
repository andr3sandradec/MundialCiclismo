package main;

import controlador.ControladorMundial;
import vista.VistaMundial;

public class Main {
    public static void main(String[] args) {
        VistaMundial vista = new VistaMundial();
        ControladorMundial controlador = new ControladorMundial(vista);
        
        controlador.iniciar();
    }
}