// Paquete principal del proyecto
package modelos;

// Clase que representa un paciente en el sistema
public class paciente {
  private final String id; // Identificador único del paciente
  private final String nombre; // Nombre del paciente
  private final int edad; // Edad del paciente
  private final String clinica; // Nombre de la clínica donde recibe atención

  // Constructor para inicializar un paciente con sus datos
  public paciente(String id, String nombre, int edad, String clinica) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    this.clinica = clinica;
  }

  // Métodos getters para obtener los atributos del paciente
  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getClinica() {
    return clinica;
  }

  // Método toString para representar un paciente como texto
  @Override
  public String toString() {
    return String.format(
        "Paciente \n" +
            "  ID: %s \n" +
            "  Nombre: %s \n" +
            "  Edad: %d \n" +
            "  Clínica: %s \n" +
            "}",
        id, nombre, edad, clinica);
  }
}