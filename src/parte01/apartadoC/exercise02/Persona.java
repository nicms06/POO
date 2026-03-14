package parte01.apartadoC.exercise02;

public class Persona {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona (){
        this.dni = " ";
        this.nombre = " ";
        this.apellidos = " ";
        this.edad = 0;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        dni = dni.replace(" ", ""); //Eliminamos espacios si los tiene

        String[] dniSeparado = dni.split("");

        if (dni.length() != 9 || !Character.isLetter((dniSeparado[8].charAt(0)))){
            throw new IllegalArgumentException("ERROR: DNI inválido");
        }

        for (int i = 0; i < dniSeparado.length - 1; i++){
            if (!Character.isDigit(dniSeparado[i].charAt(0))){
                throw new IllegalArgumentException("ERROR: DNI inválido");
            }
        }

        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){

        for (int i = 0; i < nombre.length(); i++){
            if (Character.isDigit(nombre.charAt(i))){
                throw new IllegalArgumentException("El nombre no puede contener ningún número.");
            }
        }

        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        if (edad < 0 || edad > 120){
            throw new IllegalArgumentException("ERROR: edad no válida");
        }
        this.edad = edad;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){

        for (int i = 0; i < apellidos.length(); i++){
            if (Character.isDigit(apellidos.charAt(i))){
                throw new IllegalArgumentException("Los apellidos no pueden contener ningún número.");
            }
        }

        this.apellidos = apellidos;
    }





















}
