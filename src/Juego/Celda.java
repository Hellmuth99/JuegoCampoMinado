package Juego;

public class Celda {
    private boolean tieneMina;
    private boolean descubierta;

    private int cantidadMinasAlrededor = 0;
    // otros atributos y métodos necesarios

    public boolean estaDescubierta() {
        return descubierta;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void ponerMina() {
        tieneMina = true;
    }

    public int getCantidadMinasAlrededor() {
        return cantidadMinasAlrededor;
    }
    public void incrementarNumeroMinasAlrededor(){
       this.cantidadMinasAlrededor++;
    }

    public void descubrir() {
        descubierta = true;
    }


}