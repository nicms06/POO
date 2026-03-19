package crud.ejercicio05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creación de un nuevo Scanner
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do{

        }while (opcion != 6);

        //Cerramos el Scanner
        sc.close();

    }

    /**
     * Función que muestra un menú por pantalla
     */
    static void menu(){
        System.out.println("Cuentas Corrientes");
        System.out.println("/////////////////////");
        System.out.println("1. Añadir cuenta");
        System.out.println("2. Añadir saldo");
        System.out.println("3. Sacar saldo");
        System.out.println("5. Mostrar cuentas");
        System.out.println("6. Salir");
        System.out.println("/////////////////////");
        System.out.println("Elije una opción: ");
    }
}
