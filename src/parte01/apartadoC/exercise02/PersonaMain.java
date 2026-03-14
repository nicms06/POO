package parte01.apartadoC.exercise02;

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
        String personaMayor = esMayor(persona.getEdad());

        System.out.println(persona.getNombre() + " " + persona.getApellidos() + " con DNI " + persona.getDni() + " " + personaMayor);
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

        Persona persona = new Persona();

        System.out.print("Introduce el DNI: ");
        boolean dniValidado = false;
        while (!dniValidado){
            try {
                persona.setDni(sc.nextLine());
                dniValidado = true;
            } catch (Exception e) {
                System.out.print("DNI no válido: ");
            }
        }

        System.out.print("Introduce el nombre: ");
        boolean nombreValidado = false;
        while (!nombreValidado){
            try {
                persona.setNombre(sc.nextLine());
                nombreValidado = true;
            } catch (Exception e) {
                System.out.print("Nombre no válido: ");
            }
        }

        System.out.print("Introduce los apellidos: ");
        boolean apelldiosValidados = false;
        while (!apelldiosValidados){
            try {
                persona.setApellidos(sc.nextLine());
                apelldiosValidados = true;
            } catch (Exception e) {
                System.out.print("Apellidos no válidos: ");
            }
        }

        System.out.print("Introduce la edad: ");
        boolean edadValida = false;
        while (!edadValida){
            try {
                persona.setEdad(sc.nextInt());
                sc.nextLine();
                edadValida = true;
            } catch (Exception e) {
                System.out.println("ERROR: Introduce una edad válida.");
            }
        }

        return persona;
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