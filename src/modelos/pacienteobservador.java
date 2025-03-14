// Paquete principal del proyecto
package modelos;

import java.util.List;

// Interfaz para los observadores de la lista de pacientes
class PacienteObservador implements pacienteObserver {
  @Override
  public void actualizar(List<paciente> pacientes) {
    System.out.println("\nLista de pacientes actualizada:");
    for (paciente p : pacientes) {
      System.out.println(p);
    }
  }
}
