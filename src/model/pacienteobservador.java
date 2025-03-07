// Paquete principal del proyecto
package src.model;

import java.util.List;
import src.model.Paciente;


// Interfaz para los observadores de la lista de pacientes

class PacienteObservador implements pacienteObserver {
    public void actualizar(List<Paciente> pacientes) {
        System.out.println("\nLista de pacientes actualizada:");
        for (paciente p : pacientes) {
            System.out.println(p);
        }
    }
}
