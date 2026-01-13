package EjerBiometricos.Interfaz;

import java.util.Scanner;

import EjerBiometricos.Negocio.Empleado;
import EjerBiometricos.Utilitario.Utilitario;

public class Main {

    public static void main(String[] args) {

        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);
        int opc;

        do{

            u.mostrarMenu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc){

                case 1: {
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    u.registrarEmpleado(ced, nom);
                }
                break;

                case 2: {
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.print("Token: ");
                    String tok = sc.nextLine();

                    u.agregarToken(ced, n, tok);
                }
                break;

                case 3:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.print("Patron facial: ");
                    String pf = sc.nextLine();
                    u.agregarFacial(ced, n, pf);
                }break;

                case 4:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nivel de seguridad: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.print("Patron huella: ");
                    String ph = sc.nextLine();
                    u.agregarHuella(ced, n, ph);
                }break;

                case 5:{
                    System.out.println("\n--- LISTA DE EMPLEADOS ---");
                    for(Empleado e : u.obtenerEmpleados()){
                        System.out.println(e);
                    }
                }break;

                case 6:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.println(u.listarMetodos(ced));
                }break;

                case 7:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    int total = u.totalHuellas(ced)+u.totalToken(ced)+u.totalFacial(ced);
                    System.out.println("Total métodos: " + total);
                }break;

                case 8:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.println("Total huellas: " + u.totalHuellas(ced));
                }break;

                case 9:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.println("Total tokens: " + u.totalToken(ced));
                }break;

                case 10:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.println("Total facial: " + u.totalFacial(ced));
                }break;

                case 11:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nivel mínimo: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.println(u.metodosSobreUmbral(ced, n));
                }break;

                case 12:{
                    System.out.print("Tipo (token / facial / huella): ");
                    String tipo = sc.nextLine();
                    System.out.print("Dato: ");
                    String dato = sc.nextLine();
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.println(u.autenticarMensaje(tipo, dato, ced));
                }break;
            }

        }while(opc != 13);

        System.out.println("Fin");
    }
}