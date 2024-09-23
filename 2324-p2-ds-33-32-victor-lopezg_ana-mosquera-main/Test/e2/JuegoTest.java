package e2;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JuegoTest {
    private static final Warrior warrior1 = new Warrior("Conan", 20, 8, 10);
    private static final Warrior warrior2 = new Warrior("Cid", 20, 8, 30);
    private static final Warrior warrior3 = new Warrior("Tom", 20, 8, 30);

    private static final Wizard  wizard1 = new Wizard("Gandalf", 20, 5, 10);
    private static final Wizard wizard2 = new Wizard("Harry", 20, 5, 10);
    private static final Wizard wizard3 = new Wizard("Jerry", 20, 5, 10);



    private static final ObjetoProteccion armor = new ObjetoProteccion("Armor", 5,3);
    private static final ObjetoAtaque wand = new ObjetoAtaque("Wand", 8, 2,4);
    private static final ObjetoAtaque FireBallSpell = new ObjetoAtaque("FireBallSpell", 10, 4,9);
    private static final ObjetoAtaque wand2 = new ObjetoAtaque("Wand", 8, 2,4);
    private static final ObjetoAtaque FireBallSpell2 = new ObjetoAtaque("FireBallSpell", 10, 4,2);

    @Test
    public void testSimularAtaque() {

        warrior1.escogerObjetosAtaque(wand);
        wizard1.escogerObjetosDefensivos(armor);
        Juegos.simularAtaque(warrior1, wizard1);
        assertEquals(20 - (wand.dano) + armor.proteccion, wizard1.getVida());
        warrior2.escogerObjetosAtaque(FireBallSpell);
        wizard2.escogerObjetosDefensivos(armor);
        Juegos.simularAtaque(warrior2, wizard2);
        assertEquals( 20 - (FireBallSpell.dano) + armor.proteccion, wizard2.getVida());
        wizard2.escogerObjetosAtaque(FireBallSpell);
        Juegos.simularAtaque(wizard2, warrior2);
        assertEquals(20 - (FireBallSpell.dano), warrior2.getVida());
    }

    @Test
    public void testSimularLucha() {


        wizard1.escogerObjetosDefensivos(armor);
        wizard1.escogerObjetosAtaque(FireBallSpell);
        warrior1.escogerObjetosAtaque(wand);
        assertEquals(wizard1+ " es el ganador", Juegos.simularLucha(wizard1,warrior1,10));

        wizard2.escogerObjetosAtaque(wand2);
        warrior2.escogerObjetosAtaque(FireBallSpell2);
        warrior2.escogerObjetosDefensivos(armor);
        assertEquals(warrior2+ " es el ganador", Juegos.simularLucha(wizard2,warrior2,10));

        wizard3.escogerObjetosAtaque(wand2);
        wizard3.escogerObjetosDefensivos(armor);
        warrior3.escogerObjetosAtaque(FireBallSpell2);
        warrior3.escogerObjetosDefensivos(armor);
        assertEquals("Empate", Juegos.simularLucha(warrior3, wizard3, 2));
    }


}