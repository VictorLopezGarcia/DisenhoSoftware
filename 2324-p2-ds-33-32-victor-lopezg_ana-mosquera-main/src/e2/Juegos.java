package e2;

public class Juegos {

    public static void simularAtaque(Personajes atacante, Personajes defensor){

            if(atacante.objetosAtaques[0] != null){
                if(atacante.mana >= atacante.objetosAtaques[0].minMana){
                    atacante.objetosAtaques[0].usar();
                    defensor.recibirdano(atacante.objetosAtaques[0].dano);
                    atacante.mana -= atacante.objetosAtaques[0].minMana;
                }
            }
    }

    public static String simularLucha(Personajes personaje1, Personajes personaje2, int maxTurnos){
        int turnos = 0;
        while (personaje1.vida > 0 && personaje2.vida > 0 && turnos < maxTurnos){
            simularAtaque(personaje1, personaje2);
            simularAtaque(personaje2, personaje1);
            turnos++;
        }
        if( personaje1.vida > 0 && personaje2.vida > 0){
            return ("Empate");
        }else if(personaje1.vida > 0){
            return (personaje1 + " es el ganador");
        }else{
            return (personaje2 + " es el ganador");
        }
    }
}
