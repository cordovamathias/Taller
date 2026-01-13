package EjerPersonas.Persona;

public class AlumnoPregrado extends Alumno {
    private String carrera;

    public AlumnoPregrado(String nombre, String cedula, String universidad, String carrera) {
        super(nombre, cedula, universidad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString()+"Carrera : "+ carrera;
    }
}
