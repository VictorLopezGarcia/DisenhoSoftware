package e1;

public class Ahorro extends cuenta {
    public Ahorro(String IBAN, double saldo) {
        super(IBAN, saldo);
    }

    private final double saldo = getSaldo();


    @Override
    public void ingresar(double cantidad, cliente.TipoCliente clienteBanco) {
        if (clienteBanco == cliente.TipoCliente.standard && cantidad > 1000) {
            super.ingresar(cantidad, clienteBanco);
        } else if (clienteBanco == cliente.TipoCliente.preferente && cantidad > 500) {
            super.ingresar(cantidad, clienteBanco);
        } else if (clienteBanco == cliente.TipoCliente.vip) {
            super.ingresar(cantidad, clienteBanco);
        }
    }

    @Override
    public void retirar(double cantidad, cliente.TipoCliente clienteBanco) {
        double comision;
        if (clienteBanco == cliente.TipoCliente.standard && cantidad > 0) {
            comision = cantidad * 0.04;
            if (comision < 3) comision = 3;
            if (cantidad + comision <= saldo) {
                cantidad += comision;
                super.retirar(cantidad, clienteBanco);

            }

        } else if (clienteBanco == cliente.TipoCliente.preferente && cantidad > 0) {
            comision = cantidad * 0.02;
            if (comision < 1) comision = 1;
            if (cantidad + comision <= saldo + 1000) {
                cantidad += comision;
                super.retirar(cantidad, clienteBanco);
            }
        } else if (clienteBanco == cliente.TipoCliente.vip && cantidad > 0) {
            super.retirar(cantidad, clienteBanco);
        }

    }
}
