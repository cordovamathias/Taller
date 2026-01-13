package EjerProveedor.Negocio;

import java.util.ArrayList;
import java.util.List;

public abstract class Proveedor {

    private String nombre;
    private String pais;
    private List<Contrato> contratos;

    public Proveedor(String nombre, String pais){
        this.nombre = nombre;
        this.pais = pais;
        contratos = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public String getPais(){
        return pais;
    }

    public void agregarContrato(Contrato c){
        contratos.add(c);
    }

    public List<Contrato> getContratos(){
        return contratos;
    }

    public abstract String tipoProveedor();

    @Override
    public String toString(){
        return "Proveedor: "+nombre+" - "+tipoProveedor();
    }
}
