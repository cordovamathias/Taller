package EjerProveedor.Negocio;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa {

    private String nombre;
    private List<Proveedor> proveedores;

    public ClienteEmpresa(String nombre){
        this.nombre = nombre;
        proveedores = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void contratarProveedor(Proveedor p){
        proveedores.add(p);
    }

    public String tieneProveedorTipo(String tipo){
        for(Proveedor p : proveedores){

            if(p.tipoProveedor().equalsIgnoreCase(tipo)){

                for(Contrato c : p.getContratos()){
                    if(c.activo()){
                        return "Correcto";
                    }
                }

                return "No hay contrato activo";
            }
        }
        return "No tiene proveedor de ese tipo";
    }

    public String listarContratosActivos(){
        StringBuilder sb = new StringBuilder();

        for(Proveedor p : proveedores){
            for(Contrato c : p.getContratos()){
                if(c.activo()){
                    sb.append(nombre+" - "+p.getNombre()+" - "+c+"\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return "Cliente: "+nombre;
    }
}
