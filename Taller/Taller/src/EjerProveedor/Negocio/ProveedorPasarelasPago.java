package EjerProveedor.Negocio;

public class ProveedorPasarelasPago extends Proveedor{
    public ProveedorPasarelasPago(String nombre, String pais){
        super(nombre,pais);
    }
    @Override
    public String tipoProveedor() {
        return "PasarelaPago";
    }
}
