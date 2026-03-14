package parte01.apartadoB.exercise02;

import java.util.Scanner;

public class PersonaMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Persona 1: ");
        Persona persona1 = pedirDatos(sc);
        System.out.println("\nPersona 2: ");
        Persona persona2 = pedirDatos(sc);

        mostrarFrase(persona1);
        mostrarFrase(persona2);

        sc.close();
    }

    static void mostrarFrase (Persona persona){
        String personaMayor = esMayor(persona.edad);

        System.out.println(persona.nombre + " " + persona.apellidos + " con DNI " + persona.dni + " " + personaMayor);
    }

    /**
     * Función que pide datos a una persona
     * @param sc objeto de la clase Scanner
     */
    static Persona pedirDatos (Scanner sc){

        String dni;
        String nombre;
        String apellidos;
        int edad = 0;

        System.out.print("Introduce el DNI: ");
        dni = sc.nextLine();

        while (!validarDni(dni)){
            System.out.println("ERROR: Introduzca un DNI correcto: ");
            dni = sc.nextLine();
        }

        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce los apellidos: ");
        apellidos = sc.nextLine();

        System.out.print("Introduce la edad: ");
        boolean edadValida = false;
        while (!edadValida){
            try {
                edad = sc.nextInt();
                sc.nextLine();
                edadValida = true;
            } catch (Exception e) {
                System.out.println("ERROR: Introduce una edad válida.");
            }
        }

        return new Persona(dni, nombre, apellidos, edad);
    }

    /**
     * Función que valida si un dni es válido
     * @param dni cadena que representa el dni a validar
     * @return devolvemos true si es correcto o false si no lo es
     */
    static boolean validarDni (String dni){
        dni = dni.replace(" ", ""); //Eliminamos espacios si los tiene

        String[] dniSeparado = dni.split("");

        if (dni.length() != 9 || !Character.isLetter((dniSeparado[8].charAt(0)))){
            return false;
        }

        for (int i = 0; i < dniSeparado.length - 1; i++){
            if (!Character.isDigit(dniSeparado[i].charAt(0))){
                return false;
            }
        }

        return true;
    }

    /**
     * Función que comprueba si una persona es mayor de edad
     * @param edad Número entero que representa la edad
     * @return devolvemos una cadena
     */
    static String esMayor(int edad){
        if (edad >= 18){
            return "es mayor de edad.";
        } else{
            return "es menor de edad.";
        }
    }
}