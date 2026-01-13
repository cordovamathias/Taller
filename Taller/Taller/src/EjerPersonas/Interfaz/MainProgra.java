package EjerPersonas.Interfaz;

import EjerPersonas.Persona.AlumnoMagister;
import EjerPersonas.Persona.AlumnoPregrado;
import EjerPersonas.Persona.Persona;
import EjerPersonas.Persona.ProfesorHora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgra {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<Persona>();
        int opc = 0;
        Scanner pro = new Scanner(System.in);

        do {
            System.out.println("1.INgrese el alumno pregrado");
            System.out.println("2.Ingrese el alumno magister");
            System.out.println("3.Ingrese el profesor hora");
            System.out.println("4.Mostrar Alumnos Pregrado ");
            System.out.println("5.Mostrar Alumnos Magister");
            System.out.println("6.Mostrar Cedula , horas y sueldo Profesor");
            System.out.println("7.Mostrar listado");
            System.out.println("8.Salir");
            System.out.println("Ingrese una opcion : ");

            try {
                opc = Integer.parseInt(pro.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido");
                opc = 0;
            }

            try {
                switch (opc) {
                    case 1: {
                        System.out.println("Ingrese el nombre");
                        String nom = pro.nextLine();
                        System.out.println("Ingrese la cedula ");
                        String ced = pro.nextLine();
                        System.out.println("Ingrese universidad");
                        String uni = pro.nextLine();
                        System.out.println("Ingrese la carrera");
                        String car = pro.nextLine();

                        personas.add(new AlumnoPregrado(nom, ced, uni, car));
                        System.out.println("Alumno de pregrado registrado.");
                    }
                    break;

                    case 2: {
                        System.out.println("Ingrese el nombre");
                        String nom = pro.nextLine();
                        System.out.println("Ingrese la cedula ");
                        String ced = pro.nextLine();
                        System.out.println("Ingrese universidad");
                        String uni = pro.nextLine();
                        System.out.println("Ingrese tema de tesis");
                        String tesis = pro.nextLine();

                        personas.add(new AlumnoMagister(nom, ced, uni, tesis));
                        System.out.println("Alumno de magister registrado.");
                    }
                    break;

                    case 3: {
                        System.out.println("Ingrese nombre:");
                        String nom = pro.nextLine();
                        System.out.println("Ingrese cedula:");
                        String ced = pro.nextLine();
                        System.out.println("Ingrese especialidad:");
                        String esp = pro.nextLine();
                        System.out.println("Ingrese numero de horas:");

                        int horas;
                        try {
                            horas = Integer.parseInt(pro.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Horas invalidas");
                            break;
                        }

                        personas.add(new ProfesorHora(nom, ced, esp, horas));
                        System.out.println("Profesor por hora registrado.");
                    }
                    break;

                    case 4: {
                        System.out.println("\n ALUMNOS PREGRADO : ");
                        for (Persona p : personas) {
                            if (p instanceof AlumnoPregrado) {
                                System.out.println(p);
                            }
                        }
                    }
                    break;

                    case 5: {
                        System.out.println("\n ALUMNOS MAGISTER ");
                        for (Persona p : personas) {
                            if (p instanceof AlumnoMagister) {
                                System.out.println(p);
                            }
                        }
                    }
                    break;

                    case 6: {
                        System.out.println("\nPROFESOR HORA ");
                        for (Persona p : personas) {
                            if (p instanceof ProfesorHora) {
                                ProfesorHora ph = (ProfesorHora) p;

                                System.out.println("Cedula: " + ph.getcedula());
                                System.out.println("Horas: " + ph.getHoras());

                                int sueldo = ph.getHoras() * 10;
                                System.out.println("Sueldo: " + sueldo);
                            }
                        }
                    }
                    break;

                    case 7: {
                        System.out.println("\n LISTADO GENERAL");
                        for (Persona p : personas) {
                            System.out.println(p);
                        }
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error en la operacion");
            }

        } while (opc != 8);

        System.out.println("Fin");
    }

}
