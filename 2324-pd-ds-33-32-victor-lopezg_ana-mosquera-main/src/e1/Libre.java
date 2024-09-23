package e1;

public class Libre implements  EstadoHabitacion{
    private static final Libre instancia = new Libre();
    private Libre(){}
    public static Libre getInstancia() {
        return instancia;
    }
    @Override
    public void reservar(habitacion habitacion, String cliente) {
        //No es posible, no esta lista
    }

    @Override
    public void liberar(habitacion habitacion) {
        //Ya liberada
    }

    @Override
    public void limpiar(habitacion habitacion, String personal) {
        habitacion.setEstado(Limpia.getInstancia());
        habitacion.setPersonal(personal);
    }

    @Override
    public void terminarReserva(habitacion habitacion) {
        //habitacion libre
    }

    @Override
    public void aprobarLimpieza(habitacion habitacion, String supervirsor) {
        // no esta limpia
    }
}
