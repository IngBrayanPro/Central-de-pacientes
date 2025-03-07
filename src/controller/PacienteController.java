package controller;
package centralPacientes;
// Paquete del controlador


import src.model.Paciente;
import src.model.PacienteModelo;
import src.model.pacienteModelo;

// Clase que actúa como intermediario entre la vista y el modelo
public class PacienteController {
    private PacienteModelo model; // Instancia del modelo

    // Constructor que obtiene la instancia del modelo (Singleton)
    public PacienteController() {
        this.model = PacienteModelo.getInstancia();
    }

    // Método para agregar un paciente
    public void agregarPaciente(String id, String nombre, int edad, String clinica) {
        Paciente paciente = new Paciente(id, nombre, edad, clinica);
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
        for (Paciente p : model.listarPacientes()) {
            System.out.println(p);
        }
    }
}
