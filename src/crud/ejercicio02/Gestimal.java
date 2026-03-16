package crud.ejercicio02;

import crud.ejercicio01.Alumno;

import java.util.ArrayList;

public class Gestimal {

    private ArrayList<Articulo> listaArticulos;

    /**
     * Constructor de la clase Gestimal
     */
    public Gestimal(){
        listaArticulos = new ArrayList<>();
    }

    /**
     * Metodo que se encarga de listar en líneas diferentes los artículos
     */
    public void listarArticulos(){
        if (listaArticulos.isEmpty()){
            System.out.println("ERROR: La lista está vacía");
            return;
        }
        for (Articulo articulo : listaArticulos){
            System.out.println(articulo);
        }
    }

    /**
     * Metodo que se encarga de buscar artículos por el nombre
     * @param nombre Nombre del artículo que deseamos buscar
     * @return devolvemos el objeto si existe en la lista y null si no
     */
    public Articulo buscarArticulo (String nombre){
        for (Articulo articulo : listaArticulos){
            if (articulo.getNombre().equalsIgnoreCase(nombre)){
                return articulo;
            }
        }

        return null;
    }

    /**
     * Metodo que da de alta un articulo
     * @param nombre Nombre del artículo
     * @param precio Precio del artículo
     * @param cuantosQuedan Stock del artículo
     */
    public void altaArticulo (String nombre, double precio, int cuantosQuedan){
        Articulo articulo = new Articulo(nombre, precio, cuantosQuedan);
        if (buscarArticulo(nombre) != null){
            throw new IllegalArgumentException("ERROR: El artículo ya se encuentra en la lista.");
        }
        listaArticulos.add(articulo);
    }

    /**
     * Metodo para dar de baja un objeto
     * @param nombre Nombre del artículo
     */
    public void bajaArticulo (String nombre){
        Articulo articulo = buscarArticulo(nombre);
        if (buscarArticulo(nombre) == null){
            throw new IllegalArgumentException("ERROR: El artículo no existe en la lista.");
        }
        listaArticulos.remove(articulo);
    }

    /**
     * Metodo que se encarga de modificar el precio de un artículo
     * @param nombre Nombre del artículo al que queremos cambiarle el precio
     * @param precio Precio nuevo
     */
    public void modificarArticulo (String nombre, double precio){
        Articulo articulo = buscarArticulo(nombre);
        if (articulo == null){
            throw new IllegalArgumentException("ERROR: El artículo no se encuentra en la lista.");
        }
        articulo.setPrecio(precio);
    }

    /**
     * Metodo que se encarga de añadir mercancía a un artículo
     * @param nombre Nombre del artículo al que queremos añadir mercancía
     * @param cantidad Cantidad que le queremos añadir
     */
    public void entradaMercancia (String nombre, int cantidad){
        Articulo articulo = buscarArticulo(nombre);
        if (articulo == null){
            throw new IllegalArgumentException("ERROR: El artículo no se encuentra en la lista.");
        }

        articulo.setCuantosQuedan(articulo.getCuantosQuedan() + cantidad);
    }

    /**
     * Metodo que se encarga de eliminar mercancía a un artículo
     * @param nombre Nombre del artículo al que queremos sacar mercancía
     * @param cantidad Cantidad que queremos sacar
     */
    public void salidaMercancia (String nombre, int cantidad){
        Articulo articulo = buscarArticulo(nombre);
        if (articulo == null){
            throw new IllegalArgumentException("ERROR: El artículo no se encuentra en la lista.");
        }

        if (cantidad > articulo.getCuantosQuedan()){
            throw new IllegalArgumentException("ERROR: No hay suficiente Stock.");
        }

        articulo.setCuantosQuedan(articulo.getCuantosQuedan() - cantidad);
    }
}