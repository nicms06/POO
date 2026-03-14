package parte01.apartadoC.exercise01;

public class PuntoMain {
    public static void main(String[] args) {
        Punto punto1 = new Punto(5, 0);

        Punto punto2 = new Punto(10, 10);

        Punto punto3 = new Punto(-3, 7);

        System.out.println("------< Puntos Originales >------");
        System.out.println("(" + punto1.getX() + "," + punto1.getY() + ")");
        System.out.println("(" + punto2.getX() + "," + punto2.getY() + ")");
        System.out.println("(" + punto3.getX() + "," + punto3.getY() + ")");

        punto1.setX(punto1.getX() + punto2.getY());
        punto2.setY(punto2.getY() + punto3.getY());
        punto3.setX(punto3.getX() + punto3.getY());

        System.out.println("------< Puntos Modificados >------");
        System.out.println("(" + punto1.getX() + "," + punto1.getY() + ")");
        System.out.println("(" + punto2.getX() + "," + punto2.getY() + ")");
        System.out.println("(" + punto3.getX() + "," + punto3.getY() + ")");
    }
}
