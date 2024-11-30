package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.ConexionSQLite;

public class Juego {
    private List<Personaje> personajes;

    public Juego() {
        personajes = cargarPersonajesDesdeDB();
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    private List<Personaje> cargarPersonajesDesdeDB() {
        List<Personaje> personajes = new ArrayList<>();

        String sql = "SELECT * FROM personajes";

        try (Connection conn = ConexionSQLite.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int vida = rs.getInt("vida");
                int dano = rs.getInt("dano");

                personajes.add(new Personaje(nombre, vida, dano));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar personajes: " + e.getMessage());
        }

        return personajes;
    }

    public void agregarPersonaje(Personaje personaje) {
        String sql = String.format(
                "INSERT INTO personajes(nombre, vida, dano) VALUES('%s', %d, %d)",
                personaje.getNombre(), personaje.getVida(), personaje.getDano()
        );

        try (Connection conn = ConexionSQLite.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            personajes.add(personaje);
        } catch (SQLException e) {
            System.out.println("Error al agregar personaje: " + e.getMessage());
        }
    }
}



