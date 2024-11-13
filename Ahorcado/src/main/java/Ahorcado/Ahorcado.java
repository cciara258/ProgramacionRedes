package Ahorcado;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    // Lista de palabras para el juego
    static String[] palabras = {"java", "programacion", "computadora", "redes", "algoritmo", "aplicacion", "intellij", "sistemas"};

    // Función para elegir una palabra aleatoria de la lista
    public static String elegirPalabra() {
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    // Función para mostrar el estado actual del juego
    public static void mostrarEstado(String palabra, String adivinadas) {
        StringBuilder mostrar = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            if (adivinadas.indexOf(palabra.charAt(i)) != -1) {
                mostrar.append(palabra.charAt(i)).append(" ");
            } else {
                mostrar.append("_ ").append(" ");
            }
        }
        System.out.println(mostrar.toString().trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra = elegirPalabra();  // Palabra aleatoria
        String adivinadas = "";  // Letras adivinadas por el jugador
        int intentosRestantes = 7;  // Número de intentos permitidos
        boolean juegoTerminado = false;

        System.out.println("¡Bienvenido al juego del Ahorcado!");
        System.out.println("La palabra tiene " + palabra.length() + " letras.");
       
        // El juego continúa mientras haya intentos y no se haya adivinado la palabra
        while (!juegoTerminado) {
            System.out.println("\nIntentos restantes: " + intentosRestantes);
            mostrarEstado(palabra, adivinadas);
            System.out.print("\nIntroduce una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0);
           
            // Verificar si la letra ya ha sido adivinada
            if (adivinadas.indexOf(letra) != -1) {
                System.out.println("¡Ya adivinaste esa letra! Intenta con otra.");
                continue;
            }

            // Agregar la letra a las adivinadas
            adivinadas += letra;

            // Verificar si la letra está en la palabra
            if (palabra.indexOf(letra) == -1) {
                intentosRestantes--;
                System.out.println("¡La letra " + letra + " no está en la palabra!");
            }

            // Verificar si el jugador ha ganado
            if (adivinadas.length() >= palabra.length()) {
                boolean adivinadaCorrecta = true;
                for (int i = 0; i < palabra.length(); i++) {
                    if (adivinadas.indexOf(palabra.charAt(i)) == -1) {
                        adivinadaCorrecta = false;
                        break;
                    }
                }
                if (adivinadaCorrecta) {
                    juegoTerminado = true;
                    System.out.println("\n¡Felicidades! Has adivinado la palabra correctamente: " + palabra);
                }
            }

            // Verificar si el jugador se quedó sin intentos
            if (intentosRestantes == 0) {
                juegoTerminado = true;
                System.out.println("\n¡Te has quedado sin intentos! La palabra era: " + palabra);
            }
        }

        scanner.close();
    }
}