package e1;

public class Limpia implements EstadoHabitacion{
    private static final Limpia instancia = new Limpia();
    private Limpia(){}
    public static Limpia getInstancia() {
        return instancia;
    }
    @Override
    public void reservar(habitacion habitacion, String cliente) {
        //no aprobada
    }

    @Override
    public void liberar(habitacion habitacion) {
        //no ocupada
    }

    @Override
    public void limpiar(habitacion habitacion, String personal) {
        //Ya limpia
    }

    @Override
    public void terminarReserva(habitacion habitacion) {
        //no ocupada
    }

    @Override
    public void aprobarLimpieza(habitacion habitacion, String supervirsor) {
        habitacion.setEstado(Lista.getInstancia());
        habitacion.setSupervisor(supervirsor);
        habitacion.setPersonal(null);
    }
}
