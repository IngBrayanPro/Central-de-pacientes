package vistas;

import java.util.Scanner;
import controladores.PacienteController;
import modelos.paciente;

public class VistaPaciente {
    private final Scanner scanner;
    private final PacienteController controlador;

    public VistaPaciente() {
        this.scanner = new Scanner(System.in);
        this.controlador = new PacienteController();
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            procesarOpcion(opcion);
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Central de Pacientes ---");
        System.out.println("1. Agregar Paciente");
        System.out.println("2. Buscar Paciente");
        System.out.println("3. Eliminar Paciente");
        System.out.println("4. Listar Pacientes");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int obtenerOpcion() {
        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            return -1;
        }
        return opcion;
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarPaciente();
            case 2 -> buscarPaciente();
            case 3 -> eliminarPaciente();
            case 4 -> listarPacientes();
            case 5 -> salir();
            default -> System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private void agregarPaciente() {
        System.out.print("Ingrese ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese Clínica: ");
        String clinica = scanner.nextLine();

        controlador.agregarPaciente(id, nombre, edad, clinica);
        System.out.println("Paciente agregado correctamente.");
    }

    private void buscarPaciente() {
        System.out.print("Ingrese ID del paciente a buscar: ");
        String idBuscar = scanner.nextLine();
        paciente paciente = controlador.buscarPaciente(idBuscar);
        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente);
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void eliminarPaciente() {
        System.out.print("Ingrese ID del paciente a eliminar: ");
        String idEliminar = scanner.nextLine();
        if (controlador.eliminarPaciente(idEliminar)) {
            System.out.println("Paciente eliminado correctamente.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void listarPacientes() {
        System.out.println("\nLista de Pacientes:");
        controlador.listarPacientes();
    }

    private void salir() {
        System.out.println("Saliendo del sistema...");
        scanner.close();
        System.exit(0);
    }
}
