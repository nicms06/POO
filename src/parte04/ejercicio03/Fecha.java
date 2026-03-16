package parte04.ejercicio03;

public class Fecha {
    private int dia;
    private int mes;
    private int year;

    public Fecha(){

    }

    public int getDia(){
        return dia;
    }

    public void setDia(int dia){

        if (mes == 2){
            if (dia > 28){
                throw new IllegalArgumentException("ERROR: Día no válido.");
            }
        }else if (mes % 2 == 0){
            if (dia > 30){
                throw new IllegalArgumentException("ERROR: Día no válido.");
            }
        }else{
            if (dia > 31){
                throw new IllegalArgumentException("ERROR: Día no válido.");
            }
        }

        this.dia = dia;
    }
}































