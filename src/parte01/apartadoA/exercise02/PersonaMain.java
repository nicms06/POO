package parte01.apartadoA.exercise02;

import java.util.Scanner;

public class PersonaMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        System.out.println("Persona 1: ");
        pedirDatos(persona1, sc);
        System.out.println("\nPersona 2: ");
        pedirDatos(persona2, sc);

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
     * @param persona objeto de la clase Persona
     * @param sc objeto de la clase Scanner
     */
    static void pedirDatos (Persona persona, Scanner sc){
        System.out.print("Introduce el DNI: ");
        persona.dni = sc.nextLine();

        while (!validarDni(persona.dni)){
            System.out.println("ERROR: Introduzca un DNI correcto: ");
            persona.dni = sc.nextLine();
        }

        System.out.print("Introduce el nombre: ");
        persona.nombre = sc.nextLine();

        System.out.print("Introduce los apellidos: ");
        persona.apellidos = sc.nextLine();

        System.out.print("Introduce la edad: ");
        boolean edadValida = false;
        while (!edadValida){
            try {
                persona.edad = sc.nextInt();
                sc.nextLine();
                edadValida = true;
            } catch (Exception e) {
                System.out.println("ERROR: Introduce una edad válida.");
            }
        }
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