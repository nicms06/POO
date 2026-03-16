package crud.ejercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creación de un nuevo Scanner
        Scanner sc = new Scanner(System.in);

        //Creación del gestor de alumnos
        GestorAlumnos gestor = new GestorAlumnos();

        int opcion = 0;

        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine();
            String nombre;

            switch (opcion){
                case 1:
                    gestor.listarAlumnos();
                    break;
                case 2:
                    System.out.print("Introduce el nombre del alumno: ");
                    nombre = sc.nextLine();

                    System.out.println("Introduce la media: ");
                    try {
                        double media = sc.nextDouble();
                        sc.nextLine();

                        try {
                            gestor.addAlumno(nombre, media);
                        } catch (Exception e) {
                            System.out.println("El alumno ya se encuentra en la lista.");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR: Media no válida");
                    }

                    break;
                case 3:
                    System.out.print("Introduce el nombre del alumno: ");
                    nombre = sc.nextLine();

                    System.out.println("Introduce la media: ");
                    try {
                        double media = sc.nextDouble();
                        sc.nextLine();

                        try {
                            gestor.modificarAlumno(nombre, media);
                        } catch (Exception e) {
                            System.out.println("El alumno no está en la lista.");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR: Media no válida");
                    }

                    break;
                case 4:
                    System.out.print("Introduce el nombre del alumno: ");
                    nombre = sc.nextLine();

                    try {
                        gestor.eliminarAlumno(nombre);
                    } catch (Exception e) {
                        System.out.println("ERROR: El alumno no se encuentra en la lista.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
            }
        } while (opcion != 5);

        //Cerramos el Scanner
        sc.close();
    }

    /**
     * Función que muestra un menú
     */
    static void menu(){
        System.out.println("ALUMNOS/AS");
        System.out.println("======================");
        System.out.println("1. Listado");
        System.out.println("2. Nuevo Alumno");
        System.out.println("3. Modificar");
        System.out.println("4. Borrar");
        System.out.println("5. Salir");
        System.out.println("======================");
        System.out.println("Elige una opción: ");
    }
}
