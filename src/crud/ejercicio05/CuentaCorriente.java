package crud.ejercicio05;

public class CuentaCorriente {
    private String dni;
    private String nombre;
    private double saldo = 0;
    private String nacionalidad = "Desconocido";

    public CuentaCorriente (String dni, double saldo){
        setDni(dni);
        this.saldo = saldo;
    }

    public CuentaCorriente (String dni, String nombre, double saldo){
        this(dni, saldo);
        setNombre(nombre);
    }

    public CuentaCorriente (String dni, String nombre, double saldo, String nacionalidad){
        this(dni, nombre, saldo);
        setNacionalidad(nacionalidad);
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){

        if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))){
            throw new IllegalArgumentException("ERROR: DNI no válido.");
        }

        for (int i = 0; i < dni.length() - 1; i++){
            if (!Character.isDigit(dni.charAt(i))){
                throw new IllegalArgumentException("ERROR: DNI no válido.");
            }
        }

        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre (String nombre){
        for (int i = 0; i < nombre.length(); i++){
            if (!Character.isLetter(nombre.charAt(i))){
                throw new IllegalArgumentException("ERROR: Nombre no válido.");
            }
        }

        this.nombre = nombre;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        if (saldo < 0){
            throw new IllegalArgumentException("ERROR: Saldo no válido.");
        }

        this.saldo = saldo;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad){
        for (int i = 0; i < nacionalidad.length(); i++){
            if (!Character.isLetter(nacionalidad.charAt(i))){
                throw new IllegalArgumentException("ERROR: Nacionalidad no válida.");
            }
        }

        if (!nacionalidad.equalsIgnoreCase("española") && !nacionalidad.equalsIgnoreCase("extranjera")){
            throw new IllegalArgumentException("ERROR: Nacionalidad no válida.");
        }

        this.nacionalidad = nacionalidad;
    }

    public boolean sacarDinero (double cantidad){
        if (cantidad < 0 || cantidad > this.saldo){
            return false;
        }

        this.saldo -= cantidad;
        return true;
    }

    public boolean ingresarDinero (double cantidad){
        if (cantidad < 0){
            return false;
        }

        this.saldo += cantidad;
        return true;
    }

    @Override
    public String toString(){
        return "Cuenta Corriente: {DNI: " + this.dni + ", Nombre: " + this.nombre + ", Saldo: " + this.saldo + ", Nacionalidad: " + this.nacionalidad + "}";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CuentaCorriente otraCuenta = (CuentaCorriente) obj;
        return this.dni.equalsIgnoreCase(otraCuenta.dni) &&
                this.nombre.equalsIgnoreCase(otraCuenta.nombre);
    }

}