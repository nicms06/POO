package crud.ejercicio04;

import crud.ejercicio03.GestorPizzas;

import java.util.ArrayList;

public class GestorDiscos {
    private ArrayList<Disco> listaDiscos;

    /**
     * Constructor de GestorDiscos
     */
    public GestorDiscos(){
        listaDiscos = new ArrayList<>();
    }

    /**
     * Metodo que lista los discos que se encuentran en la lista
     */
    public void listarDiscos(){
        if (listaDiscos.isEmpty()){
            System.out.println("La lista está vacía.");
        }
        for (Disco disco : listaDiscos){
            System.out.println(disco);
        }
    }

    /**
     * Metodo que añade un nuevo disco a la lista
     * @param autor Representa el nombre del autor (STrING)
     * @param titulo Representa el nombre del disco (STRING)
     * @param duracion Representa la duración del disco en minutos (DOUBLE)
     * @param genero Representa el género del disco (STRING)
     */
    public void nuevoDisco(String autor, String titulo, double duracion, String genero){
        Disco disco = new Disco(autor, titulo, duracion, genero);
        listaDiscos.add(disco);
    }

    /**
     * Metodo que se encarga de buscar un disco por su codigo y lo elimina de la lista
     * @param codigo codigo que hace de referencia de un disco en concreto
     */
    public void eliminarDisco(int codigo){
        for (Disco disco : listaDiscos){
            if (disco.getCodigo() == codigo){
                listaDiscos.remove(disco);
                return;
            }
        }
    }
}





























