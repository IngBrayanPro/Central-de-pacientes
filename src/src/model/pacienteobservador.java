// Paquete principal del proyecto
package src.model;

import java.util.List;
import src.model.pacienteobserver;


// Interfaz para los observadores de la lista de pacientes

class Pacienteobservador implements pacienteobserver {
    public void actualizar(List<paciente> pacientes) {
        System.out.println("\nLista de pacientes actualizada:");
        for (paciente p : pacientes) {
            System.out.println(p);
        }
    }
}
