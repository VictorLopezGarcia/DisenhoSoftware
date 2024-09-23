package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TestE1 {
    private static cliente cliente1;
    private static cliente cliente2;
    private static cliente cliente3;
    private static corriente cuentaC1;
    private static corriente cuentaC2;
    private static corriente cuentaC3;
    private static Ahorro cuentaA1;
    private static Ahorro cuentaA2;
    private static Ahorro cuentaA3;
    private static Ahorro cuentaIBAN1;
    private static Ahorro cuentaDNI1;
    private static corriente cuentaIBAN2;
    private static corriente cuentaDNI2;


    @BeforeAll
   static void setUp() {

        cliente1 = new cliente("49675057W", cliente.TipoCliente.standard);
        cliente2 = new cliente("45148160B", cliente.TipoCliente.preferente);
        cliente3 = new cliente("15621727G", cliente.TipoCliente.vip);


        cuentaC1 = new corriente("ES21 1465 0100 72 2030876293", 100000);
        cuentaC2 = new corriente("ES26 6723 0180 32 2673923632", 100000);
        cuentaC3 = new corriente("ES22 9876 5432 10 9876543210", 100000);
        cuentaA1 = new Ahorro("ES66 2100 0418 4012 34567891", 100000);
        cuentaA2 = new Ahorro("ES05 1234 5678 90 1234567890", 100000);
        cuentaA3 = new Ahorro("ES99 5555 5555 66 7777777777", 100000);
        cuentaIBAN1 = new Ahorro("ES21 1465 0100 72 2030876293", 100000);
        cuentaIBAN2 = new corriente("ES21 1465 0100 72 2030876293", 100000);
        cuentaDNI1 = new Ahorro("ES22 9876 5432 10 9876543210", 100000);
        cuentaDNI2 = new corriente("ES77 9876 5432 10 9876543210", 100000);

        //Asociaciones de Cuentas a clientes
        List<cuenta> listaCuentas = new ArrayList<>();

        listaCuentas.add(cuentaC1);
        listaCuentas.add(cuentaA1);
        listaCuentas.add(cuentaIBAN1);
        cliente1.asociarCuentas(listaCuentas);

        listaCuentas = new ArrayList<>();
        listaCuentas.add(cuentaC2);
        listaCuentas.add(cuentaA2);
        listaCuentas.add(cuentaIBAN2);
        listaCuentas.add(cuentaDNI1);
        cliente2.asociarCuentas(listaCuentas);

        listaCuentas = new ArrayList<>();
        listaCuentas.add(cuentaC3);
        listaCuentas.add(cuentaA3);
        listaCuentas.add(cuentaDNI2);
        cliente3.asociarCuentas(listaCuentas);

    }

    @Test
    public void equals() {

        cliente1.realizarOperacion(1000, "retirar", cuentaC1);
        assertEquals(99000, cuentaC1.getSaldo());
        cliente1.realizarOperacion(1000, "ingresar", cuentaC1);
        assertEquals(100000, cuentaC1.getSaldo());
        cliente2.realizarOperacion(1000, "retirar", cuentaC2);
        assertEquals(99000, cuentaC2.getSaldo());
        cliente2.realizarOperacion(1000, "ingresar", cuentaC2);
        assertEquals(100000, cuentaC2.getSaldo());
        cliente3.realizarOperacion(1000, "retirar", cuentaC3);
        assertEquals(99000, cuentaC3.getSaldo());
        cliente3.realizarOperacion(1000, "ingresar", cuentaC3);
        assertEquals(100000, cuentaC3.getSaldo());

        cliente1.realizarOperacion(1000, "retirar", cuentaA1);
        assertEquals(98960, cuentaA1.getSaldo());
        cliente1.realizarOperacion(1040, "ingresar", cuentaA1);
        assertEquals(100000, cuentaA1.getSaldo());
        cliente2.realizarOperacion(1000, "retirar", cuentaA2);
        assertEquals(98980, cuentaA2.getSaldo());
        cliente2.realizarOperacion(1020, "ingresar", cuentaA2);
        assertEquals(100000, cuentaA2.getSaldo());
        cliente3.realizarOperacion(1000, "retirar", cuentaA3);
        assertEquals(99000, cuentaA3.getSaldo());
        cliente3.realizarOperacion(1000, "ingresar", cuentaA3);
        assertEquals(100000, cuentaA3.getSaldo());
    }

    @Test
    public void Excepcion() {

        //Diferente dni y IBAN
        assertThrows(IllegalArgumentException.class, () -> cliente1.realizarOperacion(1000, "retirar", cuentaC2));
        assertThrows(IllegalArgumentException.class, () -> cliente1.realizarOperacion(1000, "ingresar", cuentaC2));
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "retirar", cuentaC1));
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "ingresar", cuentaC1));

        //Mismo IBAN diferente dni
        assertThrows(IllegalArgumentException.class, () -> cliente1.realizarOperacion(1000, "retirar", cuentaIBAN2));
        assertThrows(IllegalArgumentException.class, () -> cliente1.realizarOperacion(1000, "ingresar", cuentaIBAN2));
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "retirar", cuentaIBAN1));
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "ingresar", cuentaIBAN1));

        //Mismo DNI diferente IBAN
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "retirar", cuentaDNI2));
        assertThrows(IllegalArgumentException.class, () -> cliente2.realizarOperacion(1000, "ingresar", cuentaDNI2));
        assertThrows(IllegalArgumentException.class, () -> cliente3.realizarOperacion(1000, "retirar", cuentaDNI1));
        assertThrows(IllegalArgumentException.class, () -> cliente3.realizarOperacion(1000, "ingresar", cuentaDNI1));
    }

}