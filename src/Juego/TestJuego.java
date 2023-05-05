package Juego;

import java.util.Scanner;

public class TestJuego {


    private Tablero tablero;
    private Jugador jugador;

    public TestJuego(int cantidadMinas) {
        tablero = new Tablero(cantidadMinas);
        jugador = new Jugador();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            tablero.imprimirTablero();
            System.out.println("Ingrese las coordenadas de la celda que desea descubrir:");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            Celda celda = tablero.getCelda(fila, columna);
            jugador.descubrirCelda(celda);
            if(jugador.haPerdido()) {
                System.out.println("Has perdido!");
                tablero.mostrarMinas();
                break;
            }
            //VALIDACION DE QUE SI DESCUBRE O INGRESA 6 COORDENADAS VALIDAS , GANA EL JUEGO
              /*if(jugador.getCeldasDescubiertas() == 6) {
                System.out.println("Has ganado!");
                tablero.mostrarMinas();
                break;
            }*/
            if (tablero.todasCeldasDescubiertasSinMina()) {
                System.out.println("Has ganado!");
                tablero.mostrarMinas();
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione nivel de dificultad");
        System.out.println("1 - Fácil\n2 - Medio\n3 - Difícil");
        System.out.println("Ingrese el valor:");
        int dificultad = scanner.nextInt();
        int cantidadMinas;
        switch(dificultad) {
            case 1:
                cantidadMinas = 5;
                break;
            case 2:
                cantidadMinas = 8;
                break;
            case 3:
                cantidadMinas = 10;
                break;
            default:
                System.out.println("Opción inválida, se jugará en nivel fácil.");
                cantidadMinas = 5;
        }
        TestJuego campoMinado = new TestJuego(cantidadMinas);
        campoMinado.jugar();
        }
    }

