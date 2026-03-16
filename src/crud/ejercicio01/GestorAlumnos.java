package crud.ejercicio01;

import java.util.ArrayList;

public class GestorAlumnos {
    private ArrayList<Alumno> listaAlumnos;

    /**
     * Constructor de la clase GestorAlumnos
     */
    public GestorAlumnos(){
        listaAlumnos = new ArrayList<>();
    }

    /**
     * Metodo que busca a un alumno dentro de una lista mediante su nombre
     * @param nombre Nombre del alumno
     * @return devolvemos al alumno si lo encontramos y null si no lo encontramos
     */
    public Alumno buscarAlumno (String nombre){
        for (Alumno alumno : listaAlumnos){
            if (alumno.getNombre().equalsIgnoreCase(nombre)){
                return alumno;
            }
        }
        return null;
    }

    /**
     * Metodo que añade alumnos dentro de una lista
     * @param nombre Nombre del alumno (String)
     * @param media Media del alumno (Double)
     */
    public void addAlumno(String nombre, double media){
        if (buscarAlumno(nombre) != null){
            throw new IllegalArgumentException("ERROR: El alumno ya está en la lista.");
        }
        Alumno alumno = new Alumno(nombre, media);
        listaAlumnos.add(alumno);
    }

    /**
     * Metodo que modifica la nota de un alumno
     * @param nombre Nombre del alumno (String)
     * @param media Media del alumno (Double)
     */
    public void modificarAlumno(String nombre, double media){
        Alumno alumno = buscarAlumno(nombre);
        if (alumno == null){
            throw new IllegalArgumentException("ERROR: El alumno no está en la lista.");
        }
        alumno.setMedia(media);
    }

    /**
     * Metodo que elimina un alumno de una lista
     * @param nombre Nombre del alumno (String)
     */
    public void eliminarAlumno(String nombre){
        Alumno alumno = buscarAlumno(nombre);
        if (alumno == null){
            throw new IllegalArgumentException("ERROR: El alumno no se encuentra en la lista.");
        }
        listaAlumnos.remove(buscarAlumno(nombre));
    }

    /**
     * Metodo que lista un alumno en líneas separadas
     */
    public void listarAlumnos (){
        if (listaAlumnos.isEmpty()){
            System.out.println("ERROR: Lista vacía");
        }
        for (Alumno alumno : listaAlumnos){
            System.out.println(alumno);
        }
    }
}
