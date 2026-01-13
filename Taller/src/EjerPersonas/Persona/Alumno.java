package EjerPersonas.Persona;

public class Alumno extends Persona {
    private String universidad;

    public Alumno(String nombre, String cedula, String universidad) {
        super(nombre, cedula);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n universidad : " + universidad;
    }
}
