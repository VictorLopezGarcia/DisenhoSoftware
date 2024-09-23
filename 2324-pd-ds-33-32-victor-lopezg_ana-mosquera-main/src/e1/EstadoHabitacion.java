package e1;

public interface EstadoHabitacion {
    void reservar(habitacion habitacion, String cliente);
    void liberar(habitacion habitacion);
    void limpiar(habitacion habitacion, String personal);
    void terminarReserva(habitacion habitacion);
    void aprobarLimpieza(habitacion habitacion, String supervirsor);
}
