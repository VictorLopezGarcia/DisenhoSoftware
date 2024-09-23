package e2;

public class ataqueAereo extends nodo implements Estrategia {
    private final int ataque;
    private nodo nodoHijo;

    public ataqueAereo(Character nombre, int ataque) {
        setNombre(nombre);
        this.ataque = ataque;
    }

    @Override
    public String getTipo() {
        return "Ataque Aereo";
    }

    @Override
    public void simular(flota flota) {
        int dano = ataque - (2 * flota.getAntiaereo() + flota.getBlindaje());
        if (dano > 0) flota.dano(dano);
        if (flota.getHp() > 0) nodoHijo.simular(flota);
        else flota.nodoFinal = this;
    }

    @Override
    public void setHijoIzquierda(nodo nodo) {
        nodoHijo = nodo;
    }

    @Override
    public void setHijoDerecha(nodo nodo) {
        nodoHijo = nodo;
    }

    @Override
    public nodo getHijoIzquierda() {
        return nodoHijo;
    }

    @Override
    public nodo getHijoDerecha() {
        return null;
    }
}
