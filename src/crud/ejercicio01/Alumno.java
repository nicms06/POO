package crud.ejercicio01;

public class Alumno {
    private String nombre;
    private double media;

    public Alumno(String nombre){
        this(nombre, 0);
    }

    public Alumno(String nombre, double media){
        this.nombre = nombre;
        setMedia(media);
    }

    //Getters
    public String getNombre() {return nombre;}
    public double getMedia() {return media;}

    /**
     * Setter que comprueba que la media sea válida
     * @param media double que representa la media del alumno
     */
    public void setMedia(double media){
        if (media > 10 || media < 0){
            throw new IllegalArgumentException("ERROR: Media no válida.");
        }
        this.media = media;
    }

    @Override
    public String toString(){
        return "(" + nombre + ", " + media + ")";
    }
}