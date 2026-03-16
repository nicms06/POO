package crud.ejercicio02;

/**
 * Clase Artículo
 */
public class Articulo {
    private String nombre;
    private double precio;
    private final int iva = 21;
    private int cuantosQuedan;

    /**
     * Constructor de la clase Artículo con los valores inicializados a 0
     * @param nombre Nombre del artículo
     */
    public Articulo(String nombre){
        this.nombre = nombre;
        this.precio = 0;
        this.cuantosQuedan = 0;
    }

    /**
     * Constructor de la clase Artículo con los calores
     * @param nombre Nombre del Artículo
     * @param precio Precio del iva del artículo
     * @param cuantosQuedan Número de artículos que quedan
     */
    public Articulo(String nombre, double precio, int cuantosQuedan){
        this.nombre = nombre;
        this.precio = precio;
        this.cuantosQuedan = cuantosQuedan;
    }

    //Getters
    public String getNombre(){return nombre;}
    public double getPrecio(){return precio;}
    public int getIva(){return iva;}
    public int getCuantosQuedan(){return cuantosQuedan;}

    /**
     * Setter para cuantos quedan
     * @param precio Precio en double
     */
    public void setPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("ERROR: Precio no válido.");
        }
        this.precio = precio;
    }

    /**
     * Setter para cuantosQuedan
     * @param cuantosQuedan cuantosQuedan en int
     */
    public void setCuantosQuedan(int cuantosQuedan){
        if (cuantosQuedan < 0){
            throw new IllegalArgumentException("ERROR: Stock no válido.");
        }
        this.cuantosQuedan = cuantosQuedan;
    }

    @Override
    public String toString(){
        double precioIva = precio * (1 + iva / 100.0);
        return "(Nombre: " + nombre + ", Precio: " + precio + ", Precio con IVA: " + precioIva + ", Stock: " + cuantosQuedan + ")";
    }
}