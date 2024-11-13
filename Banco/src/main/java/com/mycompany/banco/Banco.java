package com.mycompany.banco;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Clase que representa a un Cliente
class Cliente {
    private String nombre;
    private boolean atendido;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.atendido = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaAtendido() {
        return atendido;
    }

    public void atender() {
        this.atendido = true;
    }

    @Override
    public String toString() {
        return nombre + (atendido ? " (Atendido)" : " (Pendiente)");
    }
}

// Clase que representa un Cajero
class Cajero {
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para atender a un cliente
    public void atenderCliente(Cliente cliente) {
        System.out.println("Cajero " + nombre + " está atendiendo a " + cliente.getNombre());
        cliente.atender();
    }
}

public class Banco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Cliente> colaClientes = new LinkedList<>();
        Cajero cajero = new Cajero("Juan");

        // Simulación de clientes llegando a la cola
        while (true) {
            System.out.println("\n1. Agregar cliente a la cola");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Ver estado de la cola");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar un cliente a la cola
                    System.out.print("Introduce el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(nombreCliente);
                    colaClientes.add(nuevoCliente);
                    System.out.println("Cliente " + nombreCliente + " ha sido agregado a la cola.");
                    break;

                case 2:
                    // Atender al siguiente cliente
                    if (!colaClientes.isEmpty()) {
                        Cliente clienteAtendido = colaClientes.poll(); // Remover el primer cliente de la cola
                        cajero.atenderCliente(clienteAtendido);
                    } else {
                        System.out.println("No hay clientes en la cola.");
                    }
                    break;

                case 3:
                    // Ver el estado de la cola
                    if (colaClientes.isEmpty()) {
                        System.out.println("No hay clientes en la cola.");
                    } else {
                        System.out.println("Estado de la cola:");
                        for (Cliente cliente : colaClientes) {
                            System.out.println(cliente);
                        }
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("Saliendo del sistema de cola de banco...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }
}
