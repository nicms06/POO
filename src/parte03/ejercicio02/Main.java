package parte03.ejercicio02;

public class Main {
    public static void main(String[] args) {
        double resultado1 = Operaciones.media(5, 8);
        double resultado2 = Operaciones.media(4, 8, 10);

        System.out.println("Resultado 2 valores: " + resultado1);
        System.out.println("Resultado 3 valores: " + resultado2);
    }
}
