package e1;

public class corriente extends cuenta {
    public corriente(String IBAN, double saldo) {
        super(IBAN, saldo);
    }

    private final double saldo = getSaldo();

    @Override
    public void ingresar(double cantidad, cliente.TipoCliente clienteBanco) {
        if (cantidad > 0) {
            super.ingresar(cantidad, clienteBanco);
        }
    }

    @Override
    public void retirar(double cantidad, cliente.TipoCliente clienteBanco) {
        if (clienteBanco == cliente.TipoCliente.standard && cantidad <= saldo) {
            super.retirar(cantidad, clienteBanco);
        } else if (clienteBanco == cliente.TipoCliente.preferente && cantidad <= saldo + 1000) {
            super.retirar(cantidad, clienteBanco);
        } else if (clienteBanco == cliente.TipoCliente.vip) {
            super.retirar(cantidad, clienteBanco);
        }
    }
}
