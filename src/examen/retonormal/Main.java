package examen.retonormal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaVehiculos lista = new ListaVehiculos();

        int opcion = 0;
        String matricula;

        do{
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    matricula = pedirMatricula(sc);

                    System.out.println("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.println("Precio base por día: ");
                    double precioBaseDia = sc.nextDouble();

                    System.out.println("PorcentajeRecargoPremium: ");
                    double porcentajeRecargoPremium = sc.nextDouble();

                    try {
                        Vehiculo vehiculo = new Vehiculo(matricula, modelo, precioBaseDia, porcentajeRecargoPremium);
                        boolean anadido = lista.anadirVehiculo(vehiculo);

                        if (anadido){
                            System.out.println("Añadido correctamente.");
                        } else{
                            System.out.println("ERROR: Matrícula ya existente.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    lista.listarTodos();
                    break;
                case 3:
                    matricula = pedirMatricula(sc);

                    Vehiculo vehiculo = lista.buscarPorMatricula(matricula);

                    if (vehiculo == null){
                        System.out.println("ERROR: Vehículo no encontrado.");
                    } else{
                        System.out.println(vehiculo);
                    }

                    break;
                case 4:
                    matricula = pedirMatricula(sc);

                    vehiculo = lista.buscarPorMatricula(matricula);

                    if (vehiculo == null) {
                        System.out.println("ERROR: Vehículo no encontrado.");
                        break;
                    }

                    System.out.print("Días alquilados: ");

                    try {
                        int diasAlquilados = Integer.parseInt(sc.nextLine());

                        vehiculo.setDiasAlquilados(diasAlquilados);
                        System.out.println("Días actualizados correctamente.");

                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Días no válidos.");
                    }

                    break;
                case 5:
                    
            }

        } while (opcion != 9);

        sc.close();
    }

    static void menu(){
        System.out.println("MENÚ");
        System.out.println("/////////////////////");
        System.out.println("1. Añadir Vehículo");
        System.out.println("2. Listar Vehículos");
        System.out.println("3. Buscar Vehículo por Matrícula");
        System.out.println("4. Modificar Días Alquilados");
        System.out.println("5. Modificar Recargo Premium");
        System.out.println("6. Modificar Precio Seguro Diario");
        System.out.println("7. Eliminar Vehículo");
        System.out.println("8. Ver Estadísticas");
        System.out.println("9. Salir");
        System.out.println("/////////////////////");
        System.out.println("Seleccione una opción: ");
    }

    static String pedirMatricula(Scanner sc){
        System.out.println("Introduzca la matrícula: ");
        return sc.nextLine();
    }
}



























































