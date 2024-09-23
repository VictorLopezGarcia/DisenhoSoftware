package e1;

public class Reservada implements EstadoHabitacion{
    private static final Reservada instancia = new Reservada();
    private Reservada(){}
    public static Reservada getInstancia() {
        return instancia;
    }
    @Override
    public void reservar(habitacion habitacion, String cliente) {
        //Ya esta reservada
    }

    @Override
    public void liberar(habitacion habitacion) {
        habitacion.setEstado(Libre.getInstancia());
        habitacion.setCliente(null);
    }

    @Override
    public void limpiar(habitacion habitacion, String personal) {
        //habitacion ocupada
    }

    @Override
    public void terminarReserva(habitacion habitacion) {
        habitacion.setEstado(Lista.getInstancia());
        habitacion.setCliente(null);
    }

    @Override
    public void aprobarLimpieza(habitacion habitacion, String supervirsor) {
        //habitacion ocupada
    }
}
