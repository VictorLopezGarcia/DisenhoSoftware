package e1;


import java.util.List;
import java.util.Objects;

public class cliente {

    public enum TipoCliente {
        standard, preferente, vip
    }
    private final String dni;
    public cuenta cuentaBancaria;
    private final TipoCliente tipo;
    protected String[] IBANList;
    public cliente(String dni, TipoCliente tipo){
        this.dni = dni;
        this.tipo = tipo;
    }

    public void asociarCuentas(List<cuenta> cuentas)
    {
        IBANList = new String[cuentas.size()];
        for (int i = 0; i < cuentas.size(); i++) {
            cuenta cuentaIBAN = cuentas.get(i);
            IBANList[i] = cuentaIBAN.getIBAN();
            cuentaIBAN.setDNI(this.getDNI());
        }
    }
    public TipoCliente getTipoCliente(){
        return tipo;
    }
    public String[] getIBANCliente(){
        return IBANList;
    }
    public String getDNI(){
        return dni;
    }

    public boolean verificar(cuenta cuenta) {
        if(Objects.equals(dni, cuenta.getDniCliente()))
        {
            cuentaBancaria = cuenta;
            return true;
        }
        else return false;
    }
    public void realizarOperacion(long cantidad, String operacion, cuenta cuenta){
        if(cuenta.verificar(getIBANCliente()) && verificar(cuenta))
        {
            if (operacion.equals("ingresar")) cuentaBancaria.ingresar(cantidad, getTipoCliente());
            else if (operacion.equals("retirar")) cuentaBancaria.retirar(cantidad, getTipoCliente());
        }else throw new IllegalArgumentException("El DNI no coincide con la cuenta.");
    }
}