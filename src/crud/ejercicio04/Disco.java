package crud.ejercicio04;

/**
 * Clase Disco
 */
public class Disco {
    private static int contador = 1;
    private int codigo;
    private String autor;
    private String titulo;
    private double duracion;
    private String genero;

    /**
     * Constructor de la clase Disco
     * @param autor Representa el nombre del autor (STrING)
     * @param titulo Representa el nombre del disco (STRING)
     * @param duracion Representa la duración del disco en minutos (DOUBLE)
     * @param genero Representa el género del disco (STRING)
     */
    public Disco(String autor, String titulo, double duracion, String genero){
        this.codigo = contador++;
        this.autor = autor;
        this.titulo = titulo;
        this.duracion = duracion;
        setGenero(genero);
    }

    public int getCodigo(){return codigo;}

    /**
     * SETTER de Duración para validar que no hayan duraciones negativas
     * @param duracion Representa la duración del disco (DOUBLE)
     */
    public void setDuracion(double duracion){
        if (duracion < 0){
            throw new IllegalArgumentException("ERROR: Duración no válida.");
        }
        this.duracion = duracion;
    }

    /**
     * SETTER que se encarga de validar el género
     * @param genero Representa el género del disco (Rock, Pop, Jazz, Blues)
     */
    public void setGenero(String genero){
        if (
                !genero.equalsIgnoreCase("Rock") &&
                !genero.equalsIgnoreCase("Pop") &&
                !genero.equalsIgnoreCase("Jazz") &&
                !genero.equalsIgnoreCase("Blues")
        ){
            throw new IllegalArgumentException("ERROR: Género no válido.");
        }
        this.genero = genero;
    }

    @Override
    public String toString(){
        return "(ID: " + codigo + ", Autor: " + autor + ", Titulo: " + titulo + ", Duración: " + duracion + ", Género: " + genero + ")";
    }

    @Override
    public boolean equals (Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Disco otraCuenta = (Disco) object;
        return this.titulo.equalsIgnoreCase(otraCuenta.titulo) &&
                this.autor.equalsIgnoreCase(otraCuenta.autor);
    }
}







































