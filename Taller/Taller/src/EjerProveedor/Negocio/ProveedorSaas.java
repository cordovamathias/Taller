package EjerProveedor.Negocio;

public class ProveedorSaas extends Proveedor{
    public ProveedorSaas(String nombre, String pais){
        super(nombre,pais);
    }
    @Override
    public String tipoProveedor() {
        return "SaaS";
    }
}
