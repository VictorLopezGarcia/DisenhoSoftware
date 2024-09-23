package e2;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ObjetosTest {
    @Test
    public void testUsarObjetoAtaque() {
        ObjetoAtaque objetoAtaque;
        objetoAtaque = new ObjetoAtaque("FireBallSpell", 10, 4, 2);
        assertEquals("FireBallSpell ataca haciendo un daño de 10", captureOutput(objetoAtaque::usar));
        assertEquals("FireBallSpell ataca haciendo un daño de 9", captureOutput(objetoAtaque::usar));
        assertEquals("FireBallSpell se quedó sin usos", captureOutput(objetoAtaque::usar));

        objetoAtaque = new ObjetoAtaque("Wand", 10, 4, 2);
        assertEquals("Wand ataca haciendo un daño de 20",captureOutput(objetoAtaque::usar));
        assertEquals("Wand ataca haciendo un daño de 10",captureOutput(objetoAtaque::usar));
        assertEquals("Wand se quedó sin usos",captureOutput(objetoAtaque::usar));
    }

    @Test
    public void testUsarObjetoProteccion() {
        ObjetoProteccion objetoProteccion = new ObjetoProteccion("Armor", 5, 3);
        String expOutput = "¡Protección con Armor! Protección: 5";
        assertEquals(expOutput, captureOutput(objetoProteccion::usar));
    }

    private String captureOutput(Runnable run) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        run.run();

        System.out.flush();
        System.setOut(originalPrintStream);
        return outputStream.toString().trim();

    }
}
