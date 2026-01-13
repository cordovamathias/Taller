package EjerVehiculos.Main;

import EjerVehiculos.Util.Utilitario;
import EjerVehiculos.Negocio.Propietario;
import java.util.Scanner;

public class MainSistemaVehiculos {
    public static void main(String[] args) {

        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);
        int opc;

        do{
            u.menu();
            opc = Integer.parseInt(sc.nextLine());

            switch(opc){

                case 1:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Telefono: ");
                    String tel = sc.nextLine();
                    u.agregarPropietario(ced, nom, tel);
                }break;

                case 2:{
                    System.out.print("Cedula propietario: ");
                    String ced = sc.nextLine();
                    Propietario p = u.buscarPropietario(ced);

                    if(p==null){
                        System.out.println("Propietario no existe");
                        break;
                    }

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    System.out.print("Traccion: ");
                    String trac = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    u.agregarAuto(marca, modelo, anio, p, trac, tipo);
                }break;

                case 3:{
                    System.out.print("Cedula propietario: ");
                    String ced = sc.nextLine();
                    Propietario p = u.buscarPropietario(ced);

                    if(p==null){
                        System.out.println("Propietario no existe");
                        break;
                    }

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    System.out.print("Altura: ");
                    double altura = Double.parseDouble(sc.nextLine());
                    System.out.print("Arranque: ");
                    String arr = sc.nextLine();

                    u.agregarMoto(marca, modelo, anio, p, altura, arr);
                }break;

                case 4:{
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.println(u.buscarVehiciuloMarca(marca));
                }break;

                case 5:{
                    System.out.println(u.listarVehiculos());
                }break;

                case 6:{
                    System.out.println(u.listaPropietarios());
                }break;

                case 7:{
                    System.out.println(u.listarAutomoviles());
                }break;

                case 8:{
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.println(u.listarNombreAnioArranqueMotoXMarca(marca));
                }break;

                case 9:{
                    System.out.print("Cedula propietario: ");
                    String ced = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = Integer.parseInt(sc.nextLine());

                    int r = u.matricular(ced, marca, anio);

                    if(r==-1) System.out.println("No encontrado");
                    else System.out.println("Valor matricula: " + r);
                }break;
            }

        }while(opc!=10);

        System.out.println("Programa finalizado.");
    }
}
