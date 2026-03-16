package parte04.ejercicio01;

/**
 * Clase que representa la hora en modo 24 horas
 */
public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    /**
     * Constructor por defecto con los valores inicializados a 0
     */
    public Hora(){
        hora = 0;
        minuto = 0;
        segundo = 0;
    }

    /**
     * Constructor con parámetros
     * @param hora Valor de la hora que está validada
     * @param minuto Valor del minuto que está validado
     * @param segundo Valor del segundo que está validado
     */
    public Hora(int hora, int minuto, int segundo){
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora(){
        return hora;
    }

    /**
     * Setter que valida la hora de forma que si no es válida lanza una excepción y, en caso de ser válida, le da el valor
     * @param hora número entero que hace referencia a la hora
     */
    public void setHora(int hora){
        if (hora > 23 || hora < 0){
            throw new IllegalArgumentException("ERROR: Hora no válida.");
        }
        this.hora = hora;
    }

    public int getMinuto(){
        return minuto;
    }

    /**
     * Setter que valida el minuto de forma que si no es válido lanza una excepción y, en caso de ser válido, le da el valor
     * @param minuto número entero que hace referencia al minuto
     */
    public void setMinuto(int minuto){
        if (minuto > 59 || minuto < 0){
            throw new IllegalArgumentException("ERROR: Minuto no válido.");
        }
        this.minuto = minuto;
    }

    public int getSegundo(){
        return segundo;
    }

    /**
     * Setter que valida el segundo de forma que si no es válido lanza una excepción y, en caso de ser válido, le da el valor
     * @param segundo número entero que hace referencia al segundo
     */
    public void setSegundo(int segundo){
        if (segundo > 59 || segundo < 0){
            throw new IllegalArgumentException("ERROR: Segundo no válido.");
        }
        this.segundo = segundo;
    }

    /**
     * Metodo que suma 1 a los segundos y va comprobando la hora y el minuto
     */
    public void sumarSegundo(){
        segundo ++;

        if (segundo == 60){
            segundo = 0;
            minuto ++;

            if (minuto == 60){
                minuto = 0;
                hora ++;

                if (hora == 24){
                    hora = 0;
                }
            }
        }
    }

}