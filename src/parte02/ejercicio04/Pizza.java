package parte02.ejercicio04;

public class Pizza {
    private static int contador = 1;
    private int codigo;
    private String size;
    private String tipo;
    private String estado = "Pedida";

    public Pizza(String size, String tipo){
        this.codigo = contador++;
        setSize(size);
        setTipo(tipo);
    }

    public int getCodigo(){
        return codigo;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        if (!size.equalsIgnoreCase("Mediana") && !size.equalsIgnoreCase("Familiar")){
            throw new IllegalArgumentException("ERROR: Tamaño no válido.");
        }
        this.size = size;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        if (!tipo.equalsIgnoreCase("Margarita") && !tipo.equalsIgnoreCase("CuatroQuesos") && !tipo.equalsIgnoreCase("Funghi")){
            throw new IllegalArgumentException("ERROR: Tipo no válido.");
        }
        this.tipo = tipo;
    }

    public String getEstado(){
        return estado;
    }

    @Override
    public String toString(){
        return codigo + ": " + size + " - " + tipo + " - " + estado;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Pizza pizza = (Pizza) object;
        return this.codigo == pizza.codigo;
    }

}
