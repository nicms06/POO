package crud.ejercicio05;

import java.util.ArrayList;

public class GestorCuentas {
    private ArrayList<CuentaCorriente> listaCuentas;

    /**
     * Constructor del gestor de cuentas
     */
    public GestorCuentas(){
        listaCuentas = new ArrayList<>();
    }

    /**
     * Metodo que busca la cuenta en la lista y si no la encuentra la añade
     * @param dni String que hace referencia a un dni
     * @param nombre String que hace referencia a un nombre
     * @param saldo Double que hace referencia al dinero que contiene la cuenta
     * @param nacionalidad String que hace referencia a la nacionalidad
     */
    public void addCuenta(String dni, String nombre, double saldo, String nacionalidad){
        CuentaCorriente cuenta = new CuentaCorriente(dni, nombre, saldo, nacionalidad);
        if(buscarCuenta(cuenta.getDni()) != null){
            throw new IllegalArgumentException("ERROR: La cuenta ya está en la lista");
        }
        listaCuentas.add(cuenta);
    }

    /**
     * Metodo que busca una cuenta en la lista mediante su dni
     * @param dni DNI del titular de la cuenta
     * @return Si encontramos la cuenta devolvemos la cuenta y si no la encontramos devolvemos null
     */
    public CuentaCorriente buscarCuenta(String dni){
        for (CuentaCorriente cuenta : listaCuentas){
            if (dni.equalsIgnoreCase(cuenta.getDni())){
                return cuenta;
            }
        }
        return null;
    }

    public void addSaldo (String dni, Double cantidad){
        if (buscarCuenta(dni) == null){
            throw new IllegalArgumentException("ERROR: La cuenta no se encuentra en la lista.");
        }

    }
}






















