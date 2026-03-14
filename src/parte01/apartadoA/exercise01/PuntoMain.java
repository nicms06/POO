package parte01.apartadoA.exercise01;

public class PuntoMain {
    public static void main(String[] args) {
        Punto punto1 = new Punto ();
        punto1.x = 5;
        punto1.y = 0;

        Punto punto2 = new Punto ();
        punto2.x = 10;
        punto2.y = 10;

        Punto punto3 = new Punto ();
        punto3.x = -3;
        punto3.y = 7;

        System.out.println("------< Puntos Originales >------");
        System.out.println("(" + punto1.x + "," + punto1.y + ")");
        System.out.println("(" + punto2.x + "," + punto2.y + ")");
        System.out.println("(" + punto3.x + "," + punto3.y + ")");

        punto1.x += punto2.y;
        punto2.y += punto3.y;
        punto3.x += punto3.y;

        System.out.println("------< Puntos Modificados >------");
        System.out.println("(" + punto1.x + "," + punto1.y + ")");
        System.out.println("(" + punto2.x + "," + punto2.y + ")");
        System.out.println("(" + punto3.x + "," + punto3.y + ")");
    }
}
