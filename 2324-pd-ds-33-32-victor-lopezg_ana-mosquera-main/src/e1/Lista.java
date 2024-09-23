package e1;

public class Lista implements EstadoHabitacion{
    private static final Lista instancia = new Lista();
    private Lista(){}
    public static Lista getInstancia() {
        return instancia;
    }

    @Override
    public void reservar(habitacion habitacion, String cliente) {
        habitacion.setEstado(Reservada.getInstancia());
        habitacion.setCliente(cliente);
        habitacion.setSupervisor(null);
    }

    @Override
    public void liberar(habitacion habitacion) {
        //no necesario, habitacion ya libre
    }

    @Override
    public void limpiar(habitacion habitacion, String personal) {
        habitacion.setEstado(Limpia.getInstancia());
        habitacion.setPersonal(personal);
        habitacion.setSupervisor(null);
    }

    @Override
    public void terminarReserva(habitacion habitacion) {
        //no es necesario, habitacion no reservada
    }

    @Override
    public void aprobarLimpieza(habitacion habitacion, String supervirsor) {
        habitacion.setSupervisor(supervirsor);
    }
}
