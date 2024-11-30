package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQLite {
    private static final String URL = "jdbc:sqlite:personajes.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static void crearTabla() {
        String sql = """
                CREATE TABLE IF NOT EXISTS personajes (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    vida INTEGER NOT NULL,
                    dano INTEGER NOT NULL
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'personajes' creada correctamente (si no existía).");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
    public static void mostrarTablas() {
        String sql = "SELECT name FROM sqlite_master WHERE type = 'table';";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
            System.out.println("Tablas en la base de datos:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las tablas: " + e.getMessage());
        }
    }
}



