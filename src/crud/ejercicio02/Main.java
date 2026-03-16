package crud.ejercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creación de un nuevo Scanner
        Scanner sc = new Scanner(System.in);

        Gestimal gestor = new Gestimal();

        char opcion;

        do{
            menu();
            String input = sc.nextLine();
            opcion = input.charAt(0);

            switch (opcion){
                case 'a':
                    gestor.listarArticulos();
                    break;
                case 'b':
                    System.out.println("Introduce el nombre del artículo: ");
                    String articulo = sc.nextLine();
                    System.out.println("Introduce el precio: ");
                    try {
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el Stock: ");
                        try {
                            int stock = sc.nextInt();
                            sc.nextLine();
                            gestor.altaArticulo(articulo, precio, stock);
                        } catch (Exception e) {
                            System.out.println("ERROR: Stock no válido.");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR: Precio no válido.");
                    }
                    break;
                case 'c':
                    System.out.println("Introduce el nombre del artículo: ");
                    articulo = sc.nextLine();

                    gestor.bajaArticulo(articulo);
                    break;
                case 'd':
                    System.out.println("Introduce el nombre del artículo: ");
                    articulo = sc.nextLine();
                    System.out.println("Introduce el precio: ");
                    try {
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        gestor.modificarArticulo(articulo, precio);
                    } catch (Exception e) {
                        System.out.println("ERROR: Precio no válido.");
                    }
                    break;
                case 'e':
                    System.out.println("Introduce el nombre del artículo: ");
                    articulo = sc.nextLine();
                    System.out.println("Introduce la cantidad: ");
                    try {
                        int cantidad = sc.nextInt();
                        sc.nextLine();

                        gestor.entradaMercancia(articulo, cantidad);
                    } catch (Exception e) {
                        System.out.println("ERROR: Cantidad no válida.");
                    }
                    break;
                case 'f':
                    System.out.println("Introduce el nombre del artículo: ");
                    articulo = sc.nextLine();
                    System.out.println("Introduce la cantidad: ");
                    try {
                        int cantidad = sc.nextInt();
                        sc.nextLine();

                        gestor.salidaMercancia(articulo, cantidad);
                    } catch (Exception e) {
                        System.out.println("ERROR: Cantidad no válida.");
                    }
                    break;
                case 'g':
                    System.out.println("Saliendo...");
            }

        } while (opcion != 'g' && opcion != 'G');

        //Cerramos el Scanner
        sc.close();
    }

    /**
     * Función que muestra el menu
     */
    static void menu(){
        System.out.println("Artículos");
        System.out.println("================");
        System.out.println("a. Listado");
        System.out.println("b. Alta");
        System.out.println("c. Baja");
        System.out.println("d. Modificación");
        System.out.println("e. Entrada de mercancía");
        System.out.println("f. Salida de mercancía");
        System.out.println("g. Salir");
        System.out.println("================");
        System.out.println("Elija una opción: ");
    }
}