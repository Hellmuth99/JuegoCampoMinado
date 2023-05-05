package Juego;

public class Tablero {
    private Celda[][] celdas = new Celda[5][5];

    //public int cantidadMinas = 4;
    //public int cantidadMinasAlrededor = 0;

    //inicio el tablero con sus casillas
    public Tablero(int cantidadMinas) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                celdas[i][j] = new Celda();
            }
        }
        generarMinas(cantidadMinas);
    }


    //metodo para generar las minas
    public void generarMinas(int cantidadMinas) {
        int minasGeneradas = 0;
        while (minasGeneradas < cantidadMinas) {
            int fila = (int) (Math.random() * 5);
            int columna = (int) (Math.random() * 5);
            if (!celdas[fila][columna].tieneMina())
                celdas[fila][columna].ponerMina();
            minasGeneradas++;
        }
    }

    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }




    public void imprimirTablero() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (celdas[i][j].estaDescubierta()) {
                    if (celdas[i][j].tieneMina()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(contarMinasAlrededor(i, j) + " ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }

    public void mostrarMinas() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println();
                if (celdas[i][j].tieneMina()) {
                    celdas[i][j].descubrir();
                }
            }
        }
        imprimirTablero();
    }


    public int contarMinasAlrededor(int fila, int columna) {
        int cantidadMinasAlrededor = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < 5 && j >= 0 && j < 5 && celdas[i][j].tieneMina()) {
                    cantidadMinasAlrededor++;
                }
            }
        }
        return cantidadMinasAlrededor;
    }


    public boolean todasCeldasDescubiertasSinMina() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!celdas[i][j].tieneMina() && !celdas[i][j].estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void descubrirCelda(int fila, int columna) {
        celdas[fila][columna].descubrir();
    }

/*    public void calcularCantidadMinasAlrededor(Celda[][] celdas, int fila, int columna) {
Celda celdas1 = new Celda();
        for(int i = fila-1; i <= fila+1; i++) {
            for(int j = columna-1; j <= columna+1; j++) {
                if(i >= 0 && i < 5 && j >= 0 && j < 5 && celdas[i][j].tieneMina()) {
                    celdas1.incrementarNumeroMinasAlrededor();
                }
            }
        }
    }*/
}