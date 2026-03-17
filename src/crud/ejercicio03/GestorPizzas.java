package crud.ejercicio03;

import java.util.ArrayList;

/**
 * Clase GestorPizzas que va a gestionar la clase Pizza
 */
public class GestorPizzas {
    private ArrayList<Pizza> listaPizzas;

    /**
     * Constructor de la clase GestorPizzas
     */
    public GestorPizzas(){
        listaPizzas = new ArrayList<>();
    }

    /**
     * Metodo que lista todas las pizzas
     */
    public void listarPizzas(){
        if (listaPizzas.isEmpty()){
            System.out.println("La lista está vacía");
        } else{
            for (Pizza pizza : listaPizzas){
                System.out.println(pizza);
            }
        }
    }

    /**
     * Metodo que añade una nueva pizza a la lista
     * @param size Tamaño de la pizza (Mediana o familiar)
     * @param tipo Tipo de la pizza (Margarita, CuatroQuesos, Funghi)
     */
    public void nuevoPedido(String size, String tipo){
        Pizza pizza = new Pizza(size, tipo);
        listaPizzas.add(pizza);
    }

    /**
     * Metodo que busca una pizza mediante el código y marca su estado como servida
     * @param codigo Codigo de identificación de la pizza
     */
    public void servirPizza(int codigo){
        for (Pizza p : listaPizzas){
            if (p.getCodigo() == codigo){
                p.servir();
                return;
            }
        }
        System.out.println("ERROR: Pizza no encontrada.");
    }

}























