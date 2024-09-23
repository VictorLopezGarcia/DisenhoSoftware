package e4P1;

import java.util.ArrayList;
import java.util.Arrays;
public class MesaBillar {
    private boolean partida;
    private ArrayList<BolaBillar> cajetin = new ArrayList<>();
    private ArrayList<BolaBillar> mesa = new ArrayList<>();

    public MesaBillar() {
        cajetin.addAll(Arrays.asList(BolaBillar.values()));
    }

    public void iniciaPartida() {
        partida = true;

        cajetin.forEach((bola) -> {
            mesa.add(bola);
        });
        cajetin.clear();
    }

    public boolean meterBola(BolaBillar b) {


        // Primero comprobamos si la bola es la negra
        if(b == BolaBillar.BOLA8)
        {
            partida = false;
            return false;
        }

        // Ahora comprobamos el resto de casos, excluyendo a la Blanca
        if (partida) {
            if (b.equals(BolaBillar.BLANCA)) {
                // Do nothing
            } else {
                mesa.remove(b);
                cajetin.add(b);
            }

            return true;
        }
        else return false;

    }

    public ArrayList<BolaBillar> bolasMesa() {
        return this.mesa;
    }

    public ArrayList<BolaBillar> bolasCajetin() {
        return this.cajetin;
    }

    public boolean esPartidaIniciada() {
        return this.partida;
    }

    public BolaBillar.BolaT obtenerGanador() {
        int bolasRayadas = 0;
        int bolasLisas = 0;
        for (BolaBillar bola : cajetin) {
            if (bola.getBolaT().equals(BolaBillar.BolaT.LISA)) {
                bolasLisas++;
            } else {
                bolasRayadas++;
            }
        }

        if (bolasLisas > bolasRayadas) {
            return BolaBillar.BolaT.LISA;
        } else if (bolasLisas < bolasRayadas) {
            return BolaBillar.BolaT.RAYADA;
        } else {
            return null;
        }
    }

}
