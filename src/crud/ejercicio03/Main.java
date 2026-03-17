package crud.ejercicio03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creación de un nuevo Scanner
        Scanner sc = new Scanner(System.in);

        GestorPizzas gestor = new GestorPizzas();

        char opcion = 0;

        do{
            menu();
            String input = sc.nextLine();
            opcion = input.charAt(0);

            switch (opcion){
                case 'a':
                    gestor.listarPizzas();
                    break;

                case 'b':
                    System.out.println("Introduce el tipo de la pizza (Margarita, CuatroQuesos, Funghi): ");
                    String tipo = sc.nextLine();

                    System.out.println("Introduce el tamaño de la pizza (Mediana o Familiar): ");
                    String size = sc.nextLine();

                    try {
                        gestor.nuevoPedido(size, tipo);
                        System.out.println("Pedido añadido correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'c':
                    System.out.println("Introduce el código de la pizza: ");
                    try {
                        int codigo = sc.nextInt();
                        sc.nextLine();

                        gestor.servirPizza(codigo);
                        System.out.println("PIZZA SERVIDA");
                    } catch (Exception e) {
                        System.out.println("ERROR: Código no válido o pizza no encontrada.");
                        sc.nextLine();
                    }
                    break;

                case 'd':
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("ERROR: Opción no válida.");
            }

        } while (opcion != 'd');

        //Cerramos el Scanner
        sc.close();
    }

    static void menu(){
        System.out.println("PIZZERÍA");
        System.out.println("=================");
        System.out.println("a. Listado de pizzas");
        System.out.println("b. Nuevo Pedido");
        System.out.println("c. Pizza servida");
        System.out.println("d. Salir");
        System.out.println("=================");
        System.out.println("Elija una opcion: ");
    }
}
