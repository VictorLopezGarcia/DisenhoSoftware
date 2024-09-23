package e4P1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MesaBillarTest {

    private MesaBillar mesa;


    @Test
    void iniciaPartida() {
        MesaBillar mesa = new MesaBillar();
        mesa.iniciaPartida();
        assertTrue(mesa.esPartidaIniciada());
    }

    @Test
    void meterBolaBolaMesaBolaCajetin() {
        MesaBillar mesa = new MesaBillar();
        mesa.iniciaPartida();

        BolaBillar bolaBlanca = BolaBillar.BLANCA;
        BolaBillar bolaNegra = BolaBillar.BOLA8;
        BolaBillar bolaLisa = BolaBillar.BOLA1;
        BolaBillar bolaRayada = BolaBillar.BOLA9;

        assertTrue(mesa.meterBola(bolaBlanca));
        assertTrue(mesa.meterBola(bolaLisa));

        assertFalse(mesa.meterBola(bolaNegra));

        mesa.iniciaPartida();

        assertTrue(mesa.meterBola(bolaBlanca));

        ArrayList<BolaBillar> bolasEnMesa = mesa.bolasMesa();
        ArrayList<BolaBillar> bolasEnCajetin = mesa.bolasCajetin();

        assertTrue(mesa.meterBola(bolaLisa));

        assertTrue(bolasEnMesa.contains(bolaBlanca));
        assertFalse(bolasEnCajetin.contains(bolaBlanca));
        assertFalse(bolasEnMesa.contains(bolaLisa));
        assertTrue(bolasEnCajetin.contains(bolaLisa));
        assertFalse(bolasEnCajetin.contains(bolaNegra));
        assertTrue(bolasEnMesa.contains(bolaRayada));
        assertFalse(bolasEnCajetin.contains(bolaRayada));

        assertFalse(mesa.meterBola(bolaNegra));
    }


    @Test
    void obtenerGanador() {
        MesaBillar mesa = new MesaBillar();

        mesa.iniciaPartida();

        BolaBillar bolaNegra = BolaBillar.BOLA8;
        BolaBillar bolaLisa1 = BolaBillar.BOLA1;
        BolaBillar bolaLisa2 = BolaBillar.BOLA2;
        BolaBillar bolaRayada1 = BolaBillar.BOLA9;
        BolaBillar bolaRayada2 = BolaBillar.BOLA10;

        mesa.meterBola(bolaLisa1);
        mesa.meterBola(bolaNegra);
        mesa.meterBola(bolaRayada1);
        mesa.meterBola(bolaRayada2);

        assertEquals(BolaBillar.BolaT.LISA, mesa.obtenerGanador());

        mesa.bolasCajetin().clear();
        mesa.bolasMesa().clear();

        mesa.iniciaPartida();

        mesa.meterBola(bolaLisa1);
        mesa.meterBola(bolaRayada1);
        mesa.meterBola(bolaRayada2);

        assertEquals(BolaBillar.BolaT.RAYADA, mesa.obtenerGanador());

        mesa.bolasCajetin().clear();
        mesa.bolasMesa().clear();

        mesa.iniciaPartida();

        mesa.meterBola(bolaLisa1);
        mesa.meterBola(bolaLisa2);
        mesa.meterBola(bolaRayada1);
        mesa.meterBola(bolaRayada2);

        assertNull(mesa.obtenerGanador());

        mesa.bolasCajetin().clear();
        mesa.bolasMesa().clear();

        mesa.iniciaPartida();

        assertNull(mesa.obtenerGanador());
    }
}