package Modelo;

public class Personaje {
    private String nombre;
    private int vida;
    private int dano;

    public Personaje(String nombre, int vida, int dano) {
        this.nombre = nombre;
        this.vida = vida;
        this.dano = dano;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }
}

