package e1;

import java.util.Objects;

public abstract class cuenta {
    private final String IBAN;
    private double saldo;
    private  String DNI;

    public cuenta(String IBAN, double saldo) {
        this.IBAN = IBAN;
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }


    public String getDniCliente() {
        return DNI;
    }
    public void ingresar(double cantidad, cliente.TipoCliente clienteBanco) {
        saldo += cantidad;
    }

    public void retirar(double cantidad, cliente.TipoCliente clienteBanco) {
        saldo -= cantidad;
    }

    public boolean verificar(String[] IBANcliente) {
        for (String s : IBANcliente) {
            if (Objects.equals(s, IBAN)) {
                return true;
            }
        }
        return false;
    }
}


