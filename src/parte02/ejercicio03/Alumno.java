package parte02.ejercicio03;

import parte02.ejercicio02.Libro;

public class Alumno {
    private String nombre;
    private double media;

    public Alumno(String nombre, double media){
        this.nombre = nombre;
        setMedia(media);
    }

    public String getNombre (){
        return nombre;
    }

    public double getMedia(){
        return media;
    }

    public void setMedia(double media){
        if (media < 0 || media > 10){
            throw new IllegalArgumentException("ERROR: Media no válida");
        }

        this.media = media;
    }

    @Override
    public String toString(){
        return nombre + " " + media;
    }

    @Override
    public boolean equals (Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Alumno alumno = (Alumno) object;
        return this.nombre.equalsIgnoreCase(alumno.nombre);
    }

}