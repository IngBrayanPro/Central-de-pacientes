// Paquete principal del proyecto
package src.model;

import java.util.List;

// Interfaz para los observadores del modelo de pacientes
public interface pacienteObserver {
    // Método que se ejecutará cuando haya cambios en la lista de pacientes
    void actualizar(List<paciente> pacientes);
}
