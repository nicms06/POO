package crud.ejercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creación de un nuevo Scanner
        Scanner sc = new Scanner(System.in);

        GestorDiscos gestor = new GestorDiscos();

        int opcion = 0;

        do{
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestor.listarDiscos();
                    break;

                case 2:
                    double duracion = 0;
                    String genero = "";

                    System.out.println("Introduce el nombre del autor:");
                    String autor = sc.nextLine();

                    System.out.println("Introduce el título:");
                    String titulo = sc.nextLine();

                    // Duración
                    boolean duracionValida = false;
                    do {
                        System.out.println("Introduce la duración en minutos:");
                        try {
                            duracion = Double.parseDouble(sc.nextLine());
                            if (duracion < 0) throw new NumberFormatException();
                            duracionValida = true;
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Duración no válida.");
                        }
                    } while (!duracionValida);

                    // Género
                    boolean generoValido = false;
                    do {
                        System.out.println("Introduce el género (Rock, Pop, Jazz, Blues):");
                        genero = sc.nextLine();
                        if (genero.equalsIgnoreCase("Rock") ||
                                genero.equalsIgnoreCase("Pop") ||
                                genero.equalsIgnoreCase("Jazz") ||
                                genero.equalsIgnoreCase("Blues")) {
                            generoValido = true;
                        } else {
                            System.out.println("ERROR: Género no válido.");
                        }
                    } while (!generoValido);

                    try {
                        gestor.nuevoDisco(autor, titulo, duracion, genero);
                        System.out.println("Disco añadido correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Introduce el código del disco:");
                    try {
                        int codigo = Integer.parseInt(sc.nextLine());
                        gestor.eliminarDisco(codigo);
                        System.out.println("Disco eliminado si existía.");
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Código no válido.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 4);

        //Cerramos el Scanner
        sc.close();
    }

    static void menu(){
        System.out.println("DISCOS");
        System.out.println("=================");
        System.out.println("1. Listado");
        System.out.println("2. Nuevo Disco");
        System.out.println("3. Borrar");
        System.out.println("4. Salir");
        System.out.println("=================");
        System.out.println("Elija una opcion: ");
    }
}
