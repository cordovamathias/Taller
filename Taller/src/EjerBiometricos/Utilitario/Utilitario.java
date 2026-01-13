package EjerBiometricos.Utilitario;

import EjerBiometricos.Negocio.*;

import java.util.ArrayList;
import java.util.List;

public class Utilitario {

    private List<Empleado> listaEmpleados;

    public Utilitario(){
        listaEmpleados = new ArrayList<>();
    }

    public List<Empleado> obtenerEmpleados(){
        return listaEmpleados;
    }

    public void registrarEmpleado(String cedula, String nombre){

        if(buscarEmpleado(cedula) == -1){
            listaEmpleados.add(new Empleado(cedula, nombre));
            System.out.println("Empleado registrado correctamente");
        }else{
            System.out.println("El empleado ya se encuentra registrado");
        }
    }

    public int buscarEmpleado(String cedula){

        for(int i = 0; i < listaEmpleados.size(); i++){
            if(listaEmpleados.get(i).getCedula().equals(cedula)){
                return i;
            }
        }
        return -1;
    }

    public void agregarHuella(String cedula, int seguridad, String patron){

        int pos = buscarEmpleado(cedula);
        if(pos != -1){
            listaEmpleados.get(pos)
                    .adicionarAut(new HuellaDigital(seguridad, patron));

            System.out.println("Huella asociada al empleado");
        }else{
            System.out.println("Empleado no encontrado");
        }
    }

    public void agregarFacial(String cedula, int seguridad, String patron){
        int pos = buscarEmpleado(cedula);
        if(pos != -1){

            if(listaEmpleados.get(pos).cantidadRegistroRostro() == 0){

                listaEmpleados.get(pos)
                        .adicionarAut(new ReconocimientoFacial(seguridad, patron));

                System.out.println("Reconocimiento facial agregado");

            }else{
                System.out.println("Solo se permite un método facial");
            }

        }else{
            System.out.println("Empleado no encontrado");
        }
    }

    public void agregarToken(String cedula, int seguridad, String token){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            listaEmpleados.get(pos)
                    .adicionarAut(new TokenSeguridad(seguridad, token));

            System.out.println("Token agregado al empleado");
        }else{
            System.out.println("Empleado no encontrado");
        }
    }
    public int totalHuellas(String cedula){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            return listaEmpleados.get(pos).cantidadRegistroHuella();
        }

        System.out.println("Empleado no encontrado");
        return -1;
    }
    public int totalFacial(String cedula){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            return listaEmpleados.get(pos).cantidadRegistroRostro();
        }
        System.out.println("Empleado no encontrado");
        return -1;
    }
    public int totalToken(String cedula){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            return listaEmpleados.get(pos).cantidadRegistroToken();
        }

        System.out.println("Empleado no encontrado");
        return -1;
    }

    public String metodosSobreUmbral(String cedula, int nivel){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            return listaEmpleados.get(pos).seguridadMayorUmbral(nivel);
        }

        return "Empleado no encontrado";
    }

    public boolean autenticar(String tipo, String dato, String cedula){

        int pos = buscarEmpleado(cedula);

        if(pos != -1){
            return listaEmpleados.get(pos).autenticar(dato, tipo);
        }

        System.out.println("Empleado no encontrado");
        return false;
    }

    public String autenticarMensaje(String tipo, String dato, String cedula){

        if(autenticar(tipo, dato, cedula)){
            return "Autenticación correcta";
        }else{
            return "Credenciales no válidas";
        }
    }

    public String listarMetodos(String cedula){

        for(Empleado e : listaEmpleados){

            if(e.getCedula().equals(cedula)){

                if(e.getAutenticaciones().isEmpty()){
                    return "El empleado no tiene métodos registrados";
                }

                StringBuilder sb = new StringBuilder();

                for(MetodoAuten m : e.getAutenticaciones()){
                    sb.append(m).append("\n");
                }

                return sb.toString();
            }
        }

        return "Empleado no encontrado";
    }


    public void mostrarMenu(){

        System.out.println("\n====== MENU PRINCIPAL ======");
        System.out.println("1. Registrar Empleado");
        System.out.println("2. Agregar Token");
        System.out.println("3. Agregar Reconocimiento Facial");
        System.out.println("4. Agregar Huella Digital");
        System.out.println("5. Mostrar Todos los Empleados");
        System.out.println("6. Buscar Empleado y Ver Detalles");
        System.out.println("7. Ver Total de Métodos Registrados");
        System.out.println("8. Ver Total de Huellas");
        System.out.println("9. Ver Total de Tokens");
        System.out.println("10. Ver Total de Reconocimiento Facial");
        System.out.println("11. Ver Métodos con Seguridad Mayor a Umbral");
        System.out.println("12. Autenticar Empleado");
        System.out.println("13. Salir");
        System.out.print("Opción: ");
    }

}
