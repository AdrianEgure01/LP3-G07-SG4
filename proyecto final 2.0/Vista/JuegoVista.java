package Vista;

import javax.swing.*;

import Modelo.Personaje;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class JuegoVista extends JFrame {
    private List<Personaje> personajes;
    private Personaje personajeSeleccionado;
    private JTextArea areaResultado;
    private JButton botonBatalla;

    public JuegoVista(List<Personaje> personajes, Personaje personajeSeleccionado) {
        this.personajes = personajes;
        this.personajeSeleccionado = personajeSeleccionado;
        initComponents();
    }

    private void initComponents() {
        setTitle("Juego de Batallas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 1));

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        // Crear botones para seleccionar personajes
        for (Personaje personaje : personajes) {
            JButton boton = new JButton(personaje.getNombre());
            boton.addActionListener(e -> {
                personajeSeleccionado = personaje;
                areaResultado.setText("Personaje seleccionado: " + personaje.getNombre());
            });
            panelBotones.add(boton);
        }

        panel.add(panelBotones, BorderLayout.CENTER);

        botonBatalla = new JButton("¡Pelear!");
        panel.add(botonBatalla, BorderLayout.SOUTH);

        panel.add(new JScrollPane(areaResultado), BorderLayout.EAST);
        add(panel);
    }

    public void addBatallaListener(ActionListener listener) {
        botonBatalla.addActionListener(listener);
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }

    public void mostrarResultado(String mensaje) {
        areaResultado.setText(mensaje);
    }
}
