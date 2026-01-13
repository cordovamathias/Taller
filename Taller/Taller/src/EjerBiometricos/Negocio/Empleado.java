package EjerBiometricos.Negocio;

import java.util.*;

public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAuten> autenticaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autenticaciones=new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MetodoAuten> getAutenticaciones() {
        return autenticaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(MetodoAuten me){
        autenticaciones.add(me);
    }

    public int cantidadRegistroHuella(){
        int cont=0;

        for (MetodoAuten m: autenticaciones){
            if(m instanceof HuellaDigital){
                cont++;
            }
        }
        return cont;
    }

    public int cantidadRegistroRostro(){
        int cont=0;

        for (MetodoAuten m: autenticaciones){
            if(m instanceof ReconocimientoFacial){
                cont++;
            }
        }
        return cont;
    }

    public int cantidadRegistroToken(){
        int cont=0;

        for (MetodoAuten m: autenticaciones){
            if(m instanceof TokenSeguridad){
                cont++;
            }
        }
        return cont;
    }

    public boolean autenticar(String dato, String tipo){
        for (MetodoAuten m: autenticaciones){
            if (m.getTipo().equalsIgnoreCase(tipo)){
                if (m.autenticar(dato)){
                    return true;
                }
            }
        }
        return false;
    }
    public void adicionarAut(MetodoAuten m){
        autenticaciones.add(m);
    }

    public String seguridadMayorUmbral(int valor){
        String seguridad="";

        for (MetodoAuten m:autenticaciones){
            if (m.getLvlSeguridad()>=valor){
                seguridad+=m.getTipo();
                seguridad+="\n";
            }
        }
        return seguridad;
    }
    @Override
    public String toString() {
        return "Cedula: " + cedula +
                "\nNombre: " + nombre +
                "\nMétodos registrados: " + autenticaciones.size();
    }
}
