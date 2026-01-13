package EjerProveedor.Negocio;

public class Contrato {

    private double precio;
    private int meses;

    public Contrato(double precio, int meses){
        this.precio = precio;
        this.meses = meses;
    }

    public double getPrecio(){
        return precio;
    }

    public int getMeses(){
        return meses;
    }

    public boolean activo(){
        return meses > 0;
    }

    @Override
    public String toString(){
        return "Contrato: $"+precio+" / "+meses+" meses";
    }
}
