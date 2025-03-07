// Paquete principal del proyecto
package src.model;

import java.util.ArrayList;
import java.util.List;

// Clase Singleton para gestionar la lista de pacientes y notificar a los observadores
public class pacienteModelo {
    private static pacienteModelo instancia; // Instancia única del Singleton
    private final List<paciente> pacientes; // Lista que almacena los pacientes
    private final List<pacienteObserver> observadores; // Lista de observadores registrados

    // Constructor privado para evitar instanciación externa
    private pacienteModelo() {
        pacientes = new ArrayList<>(); // Inicializa la lista de pacientes
        observadores = new ArrayList<>(); // Inicializa la lista de observadores
    }

    // Método estático para obtener la única instancia del modelo (Singleton)
    public static pacienteModelo getInstancia() {
        if (instancia == null) {
            instancia = new pacienteModelo(); // Crea la instancia si no existe
        }
        return instancia; // Retorna la instancia única
    }

    // Método para agregar un paciente a la lista y notificar a los observadores
    public void agregarPaciente(paciente paciente) {
        pacientes.add(paciente);
        notificarObservadores();
    }

    // Método para buscar un paciente por su ID
    public paciente buscarPaciente(String id) {
        for (paciente p : pacientes) { // Recorre la lista de pacientes
            if (p.getId().equals(id)) { // Si el ID coincide, devuelve el paciente
                return p;
            }
        }
        return null; // Retorna null si el paciente no se encuentra
    }

    // Método para eliminar un paciente por su ID y notificar a los observadores
    public boolean eliminarPaciente(String id) {
        boolean eliminado = pacientes.removeIf(p -> p.getId().equals(id)); // Elimina si el ID coincide
        if (eliminado) {
            notificarObservadores();
        }
        return eliminado;
    }

    // Método para obtener la lista de todos los pacientes registrados
    public List<paciente> listarPacientes() {
        return pacientes; // Retorna la lista completa de pacientes
    }

    // Método para registrar un observador
    public void agregarObservador(pacienteObserver observador) {
        observadores.add(observador);
    }

    // Método para notificar a todos los observadores cuando hay cambios en la lista de pacientes
    private void notificarObservadores() {
        for (pacienteObserver observador : observadores) {
            observador.actualizar(pacientes);
        }
    }
}

