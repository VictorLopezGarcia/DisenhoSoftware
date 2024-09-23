package e2;

public class Batalla extends nodo implements Estrategia {
    private int hp;
    private final int blindaje;
    private final int poder;
    private nodo nodoIzquierdo;
    private nodo nodoDerecho;

    public Batalla(Character nombre, int hp, int blindaje, int poder) {
        setNombre(nombre);
        this.hp = hp;
        this.blindaje = blindaje;
        this.poder = poder;
    }

    @Override
    public String getTipo() {
        return "Batalla";
    }

    @Override
    public void simular(flota flota) {
        int danoEnemigo = flota.getPoder() - blindaje;
        int dano = poder - flota.getBlindaje();
        if (danoEnemigo > 0) hp -= danoEnemigo;
        if (dano > 0) flota.dano(dano);
        if (flota.getHp() > 0) {
            if (hp > 0) nodoDerecho.simular(flota);
            else nodoIzquierdo.simular(flota);
        } else flota.nodoFinal = this;
    }

    @Override
    public void setHijoIzquierda(nodo nodo) {
        nodoIzquierdo = nodo;
    }

    @Override
    public void setHijoDerecha(nodo nodo) {
        nodoDerecho = nodo;
    }

    @Override
    public nodo getHijoIzquierda() {
        return nodoIzquierdo;
    }

    @Override
    public nodo getHijoDerecha() {
        return nodoDerecho;
    }
}
