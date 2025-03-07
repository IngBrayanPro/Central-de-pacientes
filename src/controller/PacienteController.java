package controller;

// Paquete del controlador

import src.model.paciente;
import src.model.pacienteModelo;

// Clase que actúa como intermediario entre la vista y el modelo
public class PacienteController {
    private final pacienteModelo model; // Instancia del modelo

    // Constructor que obtiene la instancia del modelo (Singleton)
    public PacienteController() {
        this.model = pacienteModelo.getInstancia();
    }

    // Método para agregar un paciente
    public void agregarPaciente(String id, String nombre, int edad, String clinica) {
        paciente paciente = new paciente(id, nombre, edad, clinica);
        model.agregarPaciente(paciente);
    }

    // Método para buscar un paciente por su ID
    public paciente buscarPaciente(String id) {
        return model.buscarPaciente(id);
    }

    // Método para eliminar un paciente por su ID
    public boolean eliminarPaciente(String id) {
        return model.eliminarPaciente(id);
    }

    // Método para obtener la lista de pacientes
    public void listarPacientes() {
        for (paciente p : model.listarPacientes()) {
            System.out.println(p);
        }
    }
}
