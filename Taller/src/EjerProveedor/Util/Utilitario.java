package EjerProveedor.Util;

import EjerProveedor.Negocio.*;
import java.util.ArrayList;
import java.util.List;

public class Utilitario {

    private List<Proveedor> proveedores;
    private List<ClienteEmpresa> clientes;

    public Utilitario(){
        proveedores = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor p){
        proveedores.add(p);
    }

    public void agregarCliente(ClienteEmpresa c){
        clientes.add(c);
    }

    public Proveedor buscarProveedor(String nombre){
        for(Proveedor p : proveedores){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    public ClienteEmpresa buscarCliente(String nombre){
        for(ClienteEmpresa c : clientes){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }

    public void menu(){
        System.out.println("\n--- MENU ---");
        System.out.println("1. Registrar proveedor");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Asociar proveedor a cliente");
        System.out.println("4. Crear contrato");
        System.out.println("5. Verificar tipo proveedor en cliente");
        System.out.println("6. Listar contratos activos");
        System.out.println("7. Salir");
        System.out.print("Opcion: ");
    }
}
