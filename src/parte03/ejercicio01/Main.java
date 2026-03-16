package parte03.ejercicio01;

public class Main {
    public static void main(String[] args) {
        int resultado1 = Operaciones.suma(5, 3);
        double resultado2 = Operaciones.suma(5.38, 6.12);

        System.out.println("Suma de enteros: " + resultado1);
        System.out.println("Suma de doubles]: " + resultado2);
    }
}
