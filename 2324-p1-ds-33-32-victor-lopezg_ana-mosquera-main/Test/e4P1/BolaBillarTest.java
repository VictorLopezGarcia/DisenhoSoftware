package e4P1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BolaBillarTest {

    @Test
    public void testPropiedadesBolaBlanca() {
        BolaBillar bolaBlanca = BolaBillar.BLANCA;

        assertEquals(BolaBillar.BolaN.CERO, bolaBlanca.getBolaN());
        assertEquals(BolaBillar.BolaC.BLANCO, bolaBlanca.getBolaC());
        assertEquals(BolaBillar.BolaT.LISA, bolaBlanca.getBolaT());
    }

    @Test
    public void testPropiedadesBolaNegra() {
        BolaBillar bolaNegra = BolaBillar.BOLA8;

        assertEquals(BolaBillar.BolaN.OCHO, bolaNegra.getBolaN());
        assertEquals(BolaBillar.BolaC.NEGRO, bolaNegra.getBolaC());
        assertEquals(BolaBillar.BolaT.LISA, bolaNegra.getBolaT());
    }

    @Test
    public void testPropiedadesBolaRayada() {
        BolaBillar bolaRayada = BolaBillar.BOLA9;

        assertEquals(BolaBillar.BolaN.NUEVE, bolaRayada.getBolaN());
        assertEquals(BolaBillar.BolaC.AMARILLO, bolaRayada.getBolaC());
        assertEquals(BolaBillar.BolaT.RAYADA, bolaRayada.getBolaT());
    }

    @Test
    public void testPropiedadesBolaLisa() {
        BolaBillar bolaLisa = BolaBillar.BOLA1;

        assertEquals(BolaBillar.BolaN.UNO, bolaLisa.getBolaN());
        assertEquals(BolaBillar.BolaC.AMARILLO, bolaLisa.getBolaC());
        assertEquals(BolaBillar.BolaT.LISA, bolaLisa.getBolaT());
    }
}