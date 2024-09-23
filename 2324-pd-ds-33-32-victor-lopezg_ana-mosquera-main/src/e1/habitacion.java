package e1;

public class habitacion {
    private EstadoHabitacion estado = Lista.getInstancia();
    private final String encargado;
    protected String Cliente;
    protected String personal;
    protected String Supervisor;
    int n;
    public habitacion (String encargado){
        this.encargado = encargado;
    }
    public void setN(int n){
        this.n = n;
    }
    public void limpiar(String personal){
        estado.limpiar(this, personal);
    }
    public void liberar(){
        estado.liberar(this);
    }
    public void reservar(String cliente){
        estado.reservar(this, cliente);
    }
    public void terminarReserva(){
        estado.terminarReserva(this);
    }
    public void aprobarLimpieza(String supervisor){
        estado.aprobarLimpieza(this, supervisor);
    }
    public void setEstado(EstadoHabitacion estado){
        this.estado = estado;
    }

    public void setCliente(String Cliente){
        this.Cliente = Cliente;
    }
    public void setPersonal(String Personal){
        this.personal = Personal;
    }
    public void setSupervisor(String Supervisor){
        this.Supervisor = Supervisor;
    }
    public String getCliente(){
        return Cliente;
    }
    public int getN() {
        return n;
    }
    public String getEncargado() {
        return encargado;
    }
    public String getPersonal() {
        return personal;
    }
    public EstadoHabitacion getEstado(){
        return estado;
    }
}