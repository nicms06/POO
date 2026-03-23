package examen.retonormal;

import java.util.ArrayList;

public class ListaVehiculos {
    private ArrayList<Vehiculo> listaVehiculos;

    public ListaVehiculos(){
        listaVehiculos = new ArrayList<>();
    }

    public Vehiculo buscarPorMatricula(String matricula){
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                return vehiculo;
            }
        }
        return null;
    }

    public boolean anadirVehiculo(Vehiculo v){
        if (buscarPorMatricula(v.getMatricula()) != null){
            return false;
        }
        listaVehiculos.add(v);
        return true;
    }

    public void listarTodos(){
        for (Vehiculo vehiculo : listaVehiculos){
            System.out.println(vehiculo);
        }
    }

    public boolean modificarDiasAlquilados(String matricula, int dias){
        Vehiculo vehiculo = buscarPorMatricula(matricula);
        if (vehiculo == null){
            return false;
        }
        vehiculo.setDiasAlquilados(dias);
        return true;
    }

    public boolean modificarRecargoPremium(String matricula, double porcentaje){
        Vehiculo vehiculo = buscarPorMatricula(matricula);
        if (vehiculo == null){
            return false;
        }
        vehiculo.setPorcentajeRecargoPremium(porcentaje);
        return true;
    }

    public boolean eliminarPorMatricula(String matricula){
        Vehiculo vehiculo = buscarPorMatricula(matricula);
        if (vehiculo == null){
            return false;
        }
        listaVehiculos.remove(vehiculo);
        return true;
    }

    public double calcularIngresoTotalRecargos(){
        double ingresoTotal = 0;
        for (Vehiculo vehiculo : listaVehiculos){
            ingresoTotal += vehiculo.importeRecargoPremium();
        }
        return ingresoTotal;
    }

    public void listarVehiculosPremium(){
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.porcentajeSuperior()){
                System.out.println(vehiculo);
            }
        }
    }

}