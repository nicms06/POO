package parte02.ejercicio02;

import parte02.ejercicio01.CuentaCorriente;

public class Libro {
    private String titulo;
    private String autor;
    private int ejemplares;
    private int prestados;
    private String genero;

    public Libro (String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro (String titulo, String autor, int ejemplares, int prestados){
        this(titulo, autor);
        this.ejemplares = ejemplares;
        this.prestados = prestados;
    }

    public Libro (String titulo, String autor, int ejemplares, int prestados, String genero){
        this(titulo, autor, ejemplares, prestados);
        this.genero = genero;
    }

    public String getTitulo (){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getEjemplares(){
        return ejemplares;
    }

    public void setEjemplares(int ejemplares){
        if (ejemplares < 0 || prestados > ejemplares){
            throw new IllegalArgumentException("ERROR: Número de ejemplares no válido.");
        }

        this.ejemplares = ejemplares;
    }

    public int getPrestados(){
        return prestados;
    }

    public void setPrestados(int prestados){
        if (prestados < 0 || prestados > this.ejemplares){
            throw new IllegalArgumentException("ERROR: Número de libros prestados no válido.");
        }

        this.prestados = prestados;
    }

    public String getGenero(){
       return genero;
    }

    public void setGenero(String genero){
        String[] generos = {"Narrativo", "Lírico", "Dramático", "Didáctico", "Poético"};

        boolean esValido = false;

        for (String tipoGenero : generos){
            if (tipoGenero.equalsIgnoreCase(genero)){
                esValido = true;
            }
        }

        if (!esValido){
            throw new IllegalArgumentException("ERROR: Género no válido.");
        }

        this.genero = genero;
    }

    public boolean prestarLibro (){
        if ((prestados + 1) > ejemplares){
            return false;
        }

        this.prestados ++;

        return true;
    }

    public boolean devolverLibro (){
        if (prestados <= 0){
            return false;
        }

        this.prestados --;

        return true;
    }

    @Override
    public String toString(){
        return "{Titulo: " + titulo + ", Autor: " + autor + ", Ejemplares: " + ejemplares + ", Prestados: " + prestados + ", Genero: " + genero + "}";
    }

    @Override
    public boolean equals (Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Libro otraCuenta = (Libro) object;
        return this.titulo.equalsIgnoreCase(otraCuenta.titulo) &&
                this.autor.equalsIgnoreCase(otraCuenta.autor);
    }

}