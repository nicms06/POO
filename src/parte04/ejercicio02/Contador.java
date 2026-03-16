package parte04.ejercicio02;

/**
 * Clase que representa un contador
 */
public class Contador {
    private int contador;

    public Contador(){
        this.contador = 0;
    }

    public Contador(int contador){
        setContador(contador);
    }

    public int getContador(){
        return contador;
    }

    public void setContador(int contador){
        if (contador < 0){
            throw new IllegalArgumentException("ERROR: Valor del contador no permitido.");
        }
        this.contador = contador;
    }

    public void incrementar(){
        contador ++;
    }

    public void decrementar(){
        contador --;

        if (contador < 0){
            contador = 0;
        }
    }
}
