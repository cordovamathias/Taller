package EjerPersonas.Persona;

public class Persona {
    private String nombre ;
    private String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return "Ingrese el nomnbre: "+ nombre + "Ingrese la cedula"+ cedula;

    }
}
