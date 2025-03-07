package vist;

import controller.PacienteController;
import java.util.Scanner;
import src.model.paciente;

// Clase que maneja la interacción con el usuario mediante consola
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteController controlador = new controller.PacienteController();

        while (true) {
            System.out.println("\n--- Central de Pacientes ---");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Eliminar Paciente");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese Clínica: ");
                    String clinica = scanner.nextLine();
                    controlador.agregarPaciente(id, nombre, edad, clinica);
                    System.out.println("Paciente agregado correctamente.");
                }
                case 2 -> {
                    System.out.print("Ingrese ID del paciente a buscar: ");
                    String idBuscar = scanner.nextLine();
                    paciente paciente = controlador.buscarPaciente(idBuscar);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " + paciente);
                    } else {
                        System.out.println("Paciente 1no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese ID del paciente a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    if (controlador.eliminarPaciente(idEliminar)) {
                        System.out.println("Paciente eliminado correctamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.println("\nLista de Pacientes:");
                    controlador.listarPacientes();
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
