package EjerPersonas.Persona;

public class Profesor extends Persona{
    private String especialidad;

    public Profesor(String nombre, String cedula, String especialidad) {
        super(nombre, cedula);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString()+"\n especialidad : "+ especialidad;
    }
}
