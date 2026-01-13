package EjerProveedor.Interfaz;

import EjerProveedor.Negocio.*;
import EjerProveedor.Util.Utilitario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);
        int opc;

        do{
            u.menu();
            opc = Integer.parseInt(sc.nextLine());

            switch(opc){

                case 1:{
                    System.out.print("Nombre proveedor: ");
                    String n = sc.nextLine();
                    System.out.print("Pais: ");
                    String p = sc.nextLine();
                    System.out.print("Tipo (cloud/saas/pago): ");
                    String t = sc.nextLine();

                    if(t.equalsIgnoreCase("cloud"))
                        u.agregarProveedor(new ProveedorCloud(n,p));
                    else if(t.equalsIgnoreCase("saas"))
                        u.agregarProveedor(new ProveedorSaas(n,p));
                    else
                        u.agregarProveedor(new ProveedorPasarelasPago(n,p));
                }break;

                case 2:{
                    System.out.print("Nombre cliente: ");
                    String n = sc.nextLine();
                    u.agregarCliente(new ClienteEmpresa(n));
                }break;

                case 3:{
                    System.out.print("Cliente: ");
                    String c = sc.nextLine();
                    System.out.print("Proveedor: ");
                    String p = sc.nextLine();

                    ClienteEmpresa cl = u.buscarCliente(c);
                    Proveedor pr = u.buscarProveedor(p);

                    if(cl!=null && pr!=null)
                        cl.contratarProveedor(pr);
                    else
                        System.out.println("No existe");
                }break;

                case 4:{
                    System.out.print("Proveedor: ");
                    String p = sc.nextLine();
                    Proveedor pr = u.buscarProveedor(p);

                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Meses: ");
                    int m = Integer.parseInt(sc.nextLine());

                    if(pr!=null)
                        pr.agregarContrato(new Contrato(precio,m));
                }break;

                case 5:{
                    System.out.print("Cliente: ");
                    String c = sc.nextLine();
                    System.out.print("Tipo: ");
                    String t = sc.nextLine();

                    ClienteEmpresa cl = u.buscarCliente(c);

                    if(cl!=null)
                        System.out.println(cl.tieneProveedorTipo(t));
                }break;

                case 6:{
                    System.out.print("Cliente: ");
                    String c = sc.nextLine();
                    ClienteEmpresa cl = u.buscarCliente(c);

                    if(cl!=null)
                        System.out.println(cl.listarContratosActivos());
                }break;
            }

        }while(opc!=7);

        System.out.println("Fin.");
    }
}
