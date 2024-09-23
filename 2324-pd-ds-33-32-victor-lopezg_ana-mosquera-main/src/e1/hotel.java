package e1;

import java.util.ArrayList;
import java.util.List;


public class hotel{
    private final List<habitacion> habitaciones = new ArrayList<>();
    private final String nombre;
    public hotel (String nombre){
        this.nombre = nombre;
    }
    public void anadirHabitacion(habitacion habitacion){
        habitaciones.add(habitacion);
        habitacion.setN(habitaciones.size());
    }
    public void reservarHabitacion(int n, String cliente){
        if(n <= habitaciones.size()){
            habitaciones.get(n-1).reservar(cliente);
        }
    }
    public void terminarReserva(int n){
        if(n <= habitaciones.size()){
            habitaciones.get(n-1).terminarReserva();
        }
    }
    public void limpiarHabitacion(int n, String personal){
        if(n <= habitaciones.size())
        {
            habitaciones.get(n-1).limpiar(personal);
        }
    }
    public void liberarHabitacion(int n){
        if(n <= habitaciones.size())
        {
            habitaciones.get(n-1).liberar();
        }
    }
    public void aprobarLimpieza(int n, String supervirsor){
        if(n <= habitaciones.size()){
            habitaciones.get(n-1).aprobarLimpieza(supervirsor);
        }
    }
    public List<habitacion> habDisponibles(){
        List<habitacion> disponibles = new ArrayList<>();
        for (habitacion habitacion : habitaciones) {
            if (habitacion.getEstado().equals(Lista.getInstancia())) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }
    public List<habitacion> habNoLimpias(){
        List<habitacion> pendLimpieza = new ArrayList<>();
        for (habitacion habitacion : habitaciones) {
            if (habitacion.getEstado().equals(Libre.getInstancia())) {
                pendLimpieza.add(habitacion);
            }
        }
        return pendLimpieza;
    }
    public List<habitacion> habNoApbr(){
        List<habitacion> pendAprob = new ArrayList<>();
        for (habitacion habitacion : habitaciones) {
            if (habitacion.getEstado().equals(Limpia.getInstancia())) {
                pendAprob.add(habitacion);
            }
        }
        return pendAprob;
    }

    public void mostrarEstadoHabitaciones() {
        System.out.println("***********************");
        System.out.println("Hotel "+ nombre);
        System.out.println("***********************");

        for (habitacion habitacion : habitaciones) {
            int numero = habitacion.getN();
            String cliente = habitacion.getCliente();
            String encargado = habitacion.getEncargado();
            String personal = habitacion.getPersonal();

            System.out.print("habitacion no. " + numero + ": ");

            if (habitacion.getEstado().equals(Reservada.getInstancia())) {
                System.out.print("Reservada por " + cliente + ". Ocupada.");
            } else {
                System.out.print("Libre. ");
                    if (habitacion.getEstado().equals(Lista.getInstancia())) {
                        System.out.print("Esta habitación fue aprobada por " + encargado + ".");
                    } else if (habitacion.getEstado().equals(Limpia.getInstancia())) {
                        System.out.print("Habitacion limpiada por "+ personal+", pendiente de aprovación.");
                    } else{
                        System.out.print("Pendiente de limpieza.");
                    }
            }
            System.out.println();
        }
        System.out.println("***********************");
    }
}