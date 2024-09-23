package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestE1 {

   private static hotel hotel;
   private static habitacion habitacion1;
   private static habitacion habitacion2;
   private static habitacion habitacion3;
   private static habitacion habitacion4;
   private static habitacion habitacion5;
   private static List<habitacion> lista;

    @BeforeAll
    static void setup() {
        hotel = new hotel("UDC Hills");
        habitacion1 = new habitacion("Juanito");
        habitacion2 = new habitacion("Manu");
        habitacion3 = new habitacion("Fulanita");
        habitacion4 = new habitacion("Juanito");
        habitacion5 = new habitacion("Pepe");

        hotel.anadirHabitacion(habitacion1);
        hotel.anadirHabitacion(habitacion2);
        hotel.anadirHabitacion(habitacion3);
        hotel.anadirHabitacion(habitacion4);
        hotel.anadirHabitacion(habitacion5);
    }


    @Test
    @Order(1)
    public void ReservarHabitacion(){
        hotel.reservarHabitacion(1, "Cliente1");
        hotel.reservarHabitacion(2, "Cliente2");
        hotel.reservarHabitacion(3, "Cliente3");
        hotel.reservarHabitacion(4, "Cliente4");
        hotel.reservarHabitacion(5, "Cliente5");
        hotel.reservarHabitacion(5, "Cliente6");


        assertEquals("Cliente1", habitacion1.getCliente());
        assertEquals("Cliente2", habitacion2.getCliente());
        assertEquals("Cliente5", habitacion5.getCliente());
        hotel.mostrarEstadoHabitaciones();
    }


    @Test
    @Order(2)
    public void terminarReseva(){
        ReservarHabitacion();
        hotel.terminarReserva(1);
        hotel.terminarReserva(5);

        assertEquals(habitacion1.getEstado(), Lista.getInstancia());
        assertEquals(habitacion2.getEstado(), Reservada.getInstancia());
        assertEquals(habitacion3.getEstado(), Reservada.getInstancia());
        assertEquals(habitacion4.getEstado(), Reservada.getInstancia());
        assertEquals(habitacion5.getEstado(), Lista.getInstancia());
        hotel.mostrarEstadoHabitaciones();
    }

    @Test
    @Order(3)
    public void Liberar(){
        hotel.liberarHabitacion(1);
        hotel.liberarHabitacion(2);
        hotel.liberarHabitacion(3);
        hotel.liberarHabitacion(4);

        assertEquals(habitacion1.getEstado(), Lista.getInstancia());
        assertEquals(habitacion2.getEstado(), Libre.getInstancia());
        assertEquals(habitacion3.getEstado(), Libre.getInstancia());
        assertEquals(habitacion4.getEstado(), Libre.getInstancia());
        hotel.mostrarEstadoHabitaciones();
    }

    @Test
    @Order(4)
    public void Limpiar(){
        hotel.limpiarHabitacion(5, "personal1");
        hotel.limpiarHabitacion(2, "personal2");
        hotel.limpiarHabitacion(3, "personal3");

        assertEquals(habitacion5.getEstado(), Limpia.getInstancia());
        assertEquals(habitacion2.getEstado(), Limpia.getInstancia());
        assertEquals(habitacion3.getEstado(), Limpia.getInstancia());
    }

    @Test
    @Order(6)
    public void AprobarLimpieza(){
        hotel.aprobarLimpieza(4, "Carlos");
        hotel.aprobarLimpieza(2, "Pepe");

        assertEquals(habitacion4.getEstado(), Libre.getInstancia());
        assertEquals(habitacion2.getEstado(), Lista.getInstancia());

        hotel.mostrarEstadoHabitaciones();
    }
    @Test
    @Order(7)
    public void listaDisponible() {
        lista = new ArrayList<>();
        lista.add(habitacion1);
        lista.add(habitacion2);

        assertEquals(lista, hotel.habDisponibles());
    }

    @Test
    @Order(8)
    public void listaPendLimpieza(){
        lista = new ArrayList<>();
        lista.add(habitacion4);

        assertEquals(lista, hotel.habNoLimpias());

        hotel.limpiarHabitacion(4, "personal4");
        lista.remove(habitacion4);
        assertEquals(lista, hotel.habNoLimpias());

    }

    @Test
    @Order(9)
    public void listaPendAprobacion(){
        lista = new ArrayList<>();

        lista.add(habitacion3);
        lista.add(habitacion4);
        lista.add(habitacion5);

        assertEquals(lista, hotel.habNoApbr());

        hotel.aprobarLimpieza(3, "Pedro");

        lista.remove(habitacion3);
        assertEquals(lista, hotel.habNoApbr());

        hotel.aprobarLimpieza(4, "Pedro");

        lista.remove(habitacion4);
        assertEquals(lista, hotel.habNoApbr());
    }
}