package Controlador;

import DB.ConexionSQLite;
import Modelo.Juego;
import Modelo.Personaje;
import Vista.JuegoVista;

public class Main {
    public static void main(String[] args) {
        ConexionSQLite.crearTabla();
        
        ConexionSQLite.mostrarTablas();

        Juego modelo = new Juego();

        if (modelo.getPersonajes().isEmpty()) {
            modelo.agregarPersonaje(new Personaje("Guerrero", 100, 20));
            modelo.agregarPersonaje(new Personaje("Mago", 80, 30));
            modelo.agregarPersonaje(new Personaje("Arquero", 90, 25));
            modelo.agregarPersonaje(new Personaje("Orco", 120, 15));
            modelo.agregarPersonaje(new Personaje("Esqueleto", 70, 10));
        }

        JuegoVista vista = new JuegoVista(modelo.getPersonajes(), null);
        JuegoControlador controlador = new JuegoControlador(modelo, vista);

        vista.setVisible(true);
    }

}

