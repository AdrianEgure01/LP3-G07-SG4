package Controlador;

import java.util.List;
import java.util.Random;

import Modelo.Juego;
import Modelo.Personaje;
import Vista.JuegoVista;

public class JuegoControlador {
    private Juego modelo;
    private JuegoVista vista;

    public JuegoControlador(Juego modelo, JuegoVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.addBatallaListener(e -> iniciarBatalla());
    }

    private void iniciarBatalla() {
        // Selecciona un enemigo aleatorio
        List<Personaje> personajes = modelo.getPersonajes();
        Personaje enemigo = personajes.get(new Random().nextInt(personajes.size()));

        // Simula la pelea
        String resultado = simularPelea(vista.getPersonajeSeleccionado(), enemigo);

        // Muestra el resultado en la vista
        vista.mostrarResultado(resultado);
    }

    private String simularPelea(Personaje jugador, Personaje enemigo) {
        StringBuilder resultado = new StringBuilder();

        resultado.append("¡Batalla iniciada!\n");
        resultado.append("Jugador: ").append(jugador.getNombre()).append(" (Vida: ").append(jugador.getVida()).append(", Daño: ").append(jugador.getDano()).append(")\n");
        resultado.append("Enemigo: ").append(enemigo.getNombre()).append(" (Vida: ").append(enemigo.getVida()).append(", Daño: ").append(enemigo.getDano()).append(")\n");

        // Lógica de pelea simple
        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
            enemigo.setVida(enemigo.getVida() - jugador.getDano());
            if (enemigo.getVida() > 0) {
                jugador.setVida(jugador.getVida() - enemigo.getDano());
            }
        }

        if (jugador.getVida() > 0) {
            resultado.append("¡El jugador ha ganado!\n");
        } else {
            resultado.append("¡El enemigo ha ganado!\n");
        }

        return resultado.toString();
    }
}



