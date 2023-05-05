package Juego;

public class Jugador {

    private int celdasDescubiertas = 0;
    private boolean haPerdido;

    public int getCeldasDescubiertas() {
        return celdasDescubiertas;
    }
    // otros atributos y métodos necesarios

    public boolean haPerdido() {
        return haPerdido;
    }

    public void descubrirCelda(Celda celda) {
        if(celda.estaDescubierta()) {
            System.out.println("La celda ya fue descubierta.");
        } else {
            celda.descubrir();
            celdasDescubiertas++;
            if(celda.tieneMina()) {
                haPerdido = true;
            }
        }
    }
}