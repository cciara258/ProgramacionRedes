package com.mycompany.clave;
import java.security.SecureRandom;
import java.util.Scanner;

public class Clave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean generarOtra = true;

        while (generarOtra) {
            int longitud = 12; // Longitud de la contraseña
            String contraseña = generarContraseña(longitud);
            System.out.println("Contraseña generada: " + contraseña);

            // Preguntar al usuario si desea generar otra contraseña
            System.out.print("¿Deseas generar otra contraseña? (s/n): ");
            String respuesta = scanner.next();

            if (!respuesta.equalsIgnoreCase("s")) {
                generarOtra = false;
            }
        }

        scanner.close();
    }

    public static String generarContraseña(int longitud) {
        // Definir los caracteres permitidos
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_";
        SecureRandom random = new SecureRandom();
        StringBuilder contraseña = new StringBuilder(longitud);

        // Generar la contraseña aleatoria
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            contraseña.append(caracteres.charAt(index));
        }

        return contraseña.toString();
    }
}