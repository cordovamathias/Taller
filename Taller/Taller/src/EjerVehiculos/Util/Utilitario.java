package EjerVehiculos.Util;

import EjerVehiculos.Negocio.Auto;
import EjerVehiculos.Negocio.Moto;
import EjerVehiculos.Negocio.Propietario;
import EjerVehiculos.Negocio.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Utilitario {
    private List<Propietario> propietarios;
    private List<Vehiculo> vehiculos;

    public Utilitario (){
        propietarios = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    public void agregarPropietario(String cedula, String nombre, String telefono){
        try{
            Propietario pr = burscarPropietario(cedula);
            if(pr == null){
                propietarios.add(new Propietario(cedula, nombre, telefono));
            }
            else{
                System.out.println("El propietario ya existe");
            }
        }catch(Exception e){
            System.out.println("Error al agregar propietario");
        }
    }

    public Propietario buscarPropietario (String cedula){
        try{
            for (Propietario p: propietarios) {
                if (p.getCedula().equals(cedula)){
                    return p;
                }
            }
        }catch(Exception e){
            return null;
        }
        return null;
    }

    public Propietario burscarPropietario (String cedula){
        try{
            for (Propietario p: propietarios) {
                if (p.getCedula().equals(cedula)){
                    return p;
                }
            }
        }catch(Exception e){
            return null;
        }
        return null;
    }

    public void agregarAuto(String marca, String modelo, int anio, Propietario duenio, String traccion, String tipo){
        try{
            vehiculos.add(new Auto(marca, modelo, anio, duenio,traccion,tipo));
        }catch(Exception e){
            System.out.println("Error al registrar auto");
        }
    }

    public void agregarMoto(String marca, String modelo, int anio, Propietario duenio, double altura, String arranque){
        try{
            vehiculos.add(new Moto(marca, modelo, anio, duenio, altura, arranque));
        }catch(Exception e){
            System.out.println("Error al registrar moto");
        }
    }

    public List<Vehiculo> buscarVehiciuloMarca(String marca){
        List<Vehiculo> buscar = new ArrayList<>();
        try{
            for (Vehiculo v: vehiculos) {
                if (v.getMarca().equalsIgnoreCase(marca)){
                    buscar.add(v);
                }
            }
        }catch(Exception e){
            System.out.println("Error en busqueda por marca");
        }
        return buscar;
    }

    public String listarVehiculos(){
        String aux = "";
        try{
            for(int i = 0; i < vehiculos.size(); i++){
                aux += vehiculos.get(i);
                aux += "\n";
            }
        }catch(Exception e){
            return "Error al listar vehiculos";
        }
        return aux;
    }

    public String listarNombreAnioArranqueMotoXMarca(String marca){
        StringBuilder sb = new StringBuilder();
        try{
            for(int i = 0; i < vehiculos.size(); i++){
                if (vehiculos.get(i).getMarca().equalsIgnoreCase(marca)) {
                    if (vehiculos.get(i) instanceof Moto){
                        Moto m = (Moto) vehiculos.get(i);
                        sb.append("Nombre: " + m.getDuenio().getNombre());
                        sb.append(" Anio: " + m.getAnio());
                        sb.append(" Arranque: " + m.getArranque());
                        sb.append("\n");
                    }
                }
            }
        }catch(Exception e){
            return "Error al listar motos";
        }
        return sb.toString();
    }

    public String listarAutomoviles(){
        StringBuilder sb = new StringBuilder();
        try{
            for (Vehiculo v: vehiculos){
                if (v instanceof Auto){
                    sb.append(v);
                    sb.append("\n");
                }
            }
        }catch(Exception e){
            return "Error al listar automoviles";
        }
        return sb.toString();
    }

    public String listaPropietarios(){
        StringBuilder sb =new StringBuilder();
        try{
            for(int i = 0; i < propietarios.size(); i++){
                sb.append(propietarios.get(i));
                sb.append("\n");
            }
        }catch(Exception e){
            return "Error al listar propietarios";
        }
        return sb.toString();
    }

    public int matricular(String cedula,String marca, int anio){
        try{
            for (Vehiculo v: vehiculos){
                if (v.getMarca().equalsIgnoreCase(marca)
                        && v.getDuenio().getCedula().equals(cedula)
                        && v.getAnio()==anio){
                    return v.matricula();
                }
            }
        }catch(Exception e){
            return -1;
        }
        return -1;
    }

    public void menu(){
        System.out.println("1. Agregar Propietario");
        System.out.println("2. Asignar Propietario a Auto");
        System.out.println("3. Asignar Propietario a Moto");
        System.out.println("4. Buscar Vehiculos por Marca");
        System.out.println("5. Listar Vehiiculos");
        System.out.println("6. Listar Propietarios");
        System.out.println("7. Listar Automoviles");
        System.out.println("8. Listar Motos por Marca");
        System.out.println("9. Matricular");
        System.out.println("10. Salir");
        System.out.println("Ingrese una opcion para continuar: ");
    }
}
