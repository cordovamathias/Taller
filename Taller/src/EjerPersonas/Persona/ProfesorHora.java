package EjerPersonas.Persona;

public class ProfesorHora extends Profesor{
    private int horas;

    public ProfesorHora(String nombre, String cedula, String especialidad, int horas) {
        super(nombre, cedula, especialidad);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.toString()+"\nHoras : "+ horas;
    }
}
