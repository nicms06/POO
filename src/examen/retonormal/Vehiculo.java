package examen.retonormal;

public class Vehiculo {
    private String matricula;
    private String modelo;
    private double precioBaseDia;
    private double porcentajeRecargoPremium;
    private static double precioSeguroDiario;
    private int diasAlquilados;

    public Vehiculo(String matricula, String modelo, double precioBaseDia, double porcentajeRecargoPremium, int diasAlquilados){
        setMatricula(matricula);
        this.modelo = modelo;
        setPrecioBaseDia(precioBaseDia);
        setPorcentajeRecargoPremium(porcentajeRecargoPremium);
        setDiasAlquilados(diasAlquilados);
    }

    public Vehiculo(String matricula, String modelo, double precioBaseDia, double porcentajeRecargoPremium){
        setMatricula(matricula);
        this.modelo = modelo;
        setPrecioBaseDia(precioBaseDia);
        setPorcentajeRecargoPremium(porcentajeRecargoPremium);
    }

    public String getMatricula(){return matricula;}

    /**
     * Metodo que comprueba que la matrícula sea válida. Para ello se debe cumplir que:
     *
     *      - La longitud de la matricula tiene que ser de 7.
     *      - Los 4 primeros valores tienen que ser numéricos.
     *      - Los 3 últimos valores tienen que ser caracteres.
     *
     * @param matricula la matricula a asignar
     */
    public void setMatricula(String matricula){
        if (matricula.length() != 7){
            throw new IllegalArgumentException("ERROR: Matrícula no válida");
        }
        for (int indiceCaracter = 0; indiceCaracter < 4; indiceCaracter++){
            if (!Character.isDigit(matricula.charAt(indiceCaracter))){
                throw new IllegalArgumentException("ERROR: Matrícula no válida");
            }
        }
        for (int indiceCaracter = 4; indiceCaracter < 7; indiceCaracter++){
            if (!Character.isLetter(matricula.charAt(indiceCaracter))){
                throw new IllegalArgumentException("ERROR: Matrícula no válida");
            }
        }
        this.matricula = matricula.toUpperCase();
    }

    /**
     * Metodo que valida que el preio base por día sea válido.
     * Para ello se debe de cumplir que el precio no sea negativo
     * @param precioBaseDia precio a asignar
     */
    public void setPrecioBaseDia(double precioBaseDia){
        if (precioBaseDia < 0){
            throw new IllegalArgumentException("ERROR: Precio no válido.");
        }
        this.precioBaseDia = precioBaseDia;
    }

    /**
     * Metodo que valida que el porcentaje de recargo premium sea válido.
     * Para ello se debe de cumplir que esté entre 0% y 25%
     * @param porcentajeRecargoPremium porcentaje a asignar
     */
    public void setPorcentajeRecargoPremium (double porcentajeRecargoPremium){
        if (porcentajeRecargoPremium < 0 || porcentajeRecargoPremium > 25){
            throw new IllegalArgumentException("ERROR: Porcentaje no válido.");
        }
        this.porcentajeRecargoPremium = porcentajeRecargoPremium;
    }

    /**
     * Metodo que valida que el número de días alquilados de un vehículo sea válido.
     * Para ello se debe de cumplir que el número de días no sea negativo.
     * @param diasAlquilados días a asignar
     */
    public void setDiasAlquilados (int diasAlquilados){
        if (diasAlquilados < 0){
            throw new IllegalArgumentException("ERROR: Número de días no válido.");
        }
        this.diasAlquilados = diasAlquilados;
    }

    /**
     * Metodo que valida si el precio del seguro diario es válido.
     * Para ello se debe de cumplir que el precio no sea negativo.
     * @param precio precio a asignar
     */
    public static void setPrecioSeguroDiario (double precio){
        if (precio < 0 ){
            throw new IllegalArgumentException("ERROR: Precio no válido.");
        }
        precioSeguroDiario = precio;
    }

    /**
     * Metodo que calcula el importe del recargo premium
     * @return Devolvemos el valor de la operación
     */
    public double importeRecargoPremium(){
        return precioBaseDia * porcentajeRecargoPremium / 100.0;
    }

    /**
     * Metodo que calcula el importe total del seguro
     * @return Devuelve el valor del importe total del seguro
     */
    public double importeTotalSeguro(){
        return diasAlquilados * precioSeguroDiario;
    }

    /**
     * Metodo que calcula el ingreso total de un vehículo
     * @return Devolvemos el ingreso total
     */
    public double ingresoTotal(){
        return precioBaseDia + porcentajeRecargoPremium + precioSeguroDiario;
    }

    /**
     * Metodo que muestra los datos de un vehículo
     * @return Devuelve en forma de cadena los datos
     */
    @Override
    public String toString(){
        return matricula + " - " + modelo + "\n" +
                "Precio Base/Día: " + precioBaseDia +
                " | Recargo Premium: " + porcentajeRecargoPremium +
                " (" + porcentajeRecargoPremium + "%)\n" +
                "Días alquilado: " + diasAlquilados +
                " | Total generado: " + ingresoTotal();
    }

    /**
     * Metodo que comprueba si dos vehiculos son iguales.
     * Para ello se debe de cumplir que ambos vehículos tengan la misma matricula
     * @param object   the reference object with which to compare.
     * @return Devolvemos true si son el mismo vehículo. En caso contrario devolvemos false.
     */
    @Override
    public boolean equals (Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Vehiculo otroVehiculo = (Vehiculo) object;
        return this.matricula.equalsIgnoreCase(otroVehiculo.matricula);
    }

    /**
     * Metodo que comprueba si el porcentaje de recargo premium es mayor a 12
     * @return Devolvemos true si es mayor a 12 y false si es menor o igual a 12
     */
    public boolean porcentajeSuperior(){
        return porcentajeRecargoPremium > 12;
    }

}